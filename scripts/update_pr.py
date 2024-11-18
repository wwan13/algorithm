import requests
import random
import re
import base64
import os

# GitHub 및 Solved.ac API URL 및 헤더
BASE_URL = "https://api.github.com/repos/wwan13/algorithm"
GITHUB_TOKEN = os.getenv("GITHUB_TOKEN")
SOLVED_AC_URL = "https://solved.ac/api/v3/problem/show"
HEADERS = {
    "Authorization": f"Bearer {GITHUB_TOKEN}",
    "Accept": "application/vnd.github.v3+json"
}


def get_problem_info(problem_number):
    """solved.ac API를 사용하여 문제 정보를 가져옴."""
    response = requests.get(f"{SOLVED_AC_URL}?problemId={problem_number}")
    if response.status_code != 200:
        print(f"문제 {problem_number} 정보를 가져오지 못했습니다.")
        return None
    return response.json()


def get_pr_files(pr_number):
    """PR의 파일 목록을 가져옴."""
    response = requests.get(f"{BASE_URL}/pulls/{pr_number}/files", headers=HEADERS)
    if response.status_code == 200:
        return response.json()
    else:
        print(f"PR #{pr_number}의 파일을 가져오는 데 실패했습니다: {response.json()}")
        return []


def get_file_content(file_url):
    """파일의 내용을 가져옴."""
    response = requests.get(file_url, headers=HEADERS)
    if response.status_code == 200:
        file_data = response.json()
        content = base64.b64decode(file_data['content']).decode('utf-8')
        return content
    else:
        print(f"파일 내용을 가져오는 데 실패했습니다: {response.json()}")
        return ""


def create_label(label_name_english, label_name_korean):
    """GitHub에 레이블 생성."""
    random_color = ''.join([random.choice('0123456789ABCDEF') for _ in range(6)])
    data = {
        "name": label_name_english,
        "color": random_color,
        "description": label_name_korean
    }
    response = requests.post(f"{BASE_URL}/labels", headers=HEADERS, json=data)
    if response.status_code == 201:
        print(f"레이블 '{label_name_english}' 생성 완료.")
    elif response.status_code == 422:
        print(f"레이블 '{label_name_english}'가 이미 존재합니다.")
    else:
        print(f"레이블 생성 실패: {response.json()}")


def set_pr_labels(pr_number, labels):
    data = {"labels": labels}
    response = requests.post(f"{BASE_URL}/issues/{pr_number}/labels", headers=HEADERS, json=data)
    if response.status_code == 200:
        print(f"PR #{pr_number}에 레이블 {labels} 설정 완료.")
    else:
        print(f"PR #{pr_number}에 레이블 설정 실패: {response.json()}")


def update_pr(pr_number, title, body):
    """PR 제목과 내용을 업데이트."""
    data = {
        "title": title,
        "body": body
    }
    response = requests.patch(f"{BASE_URL}/pulls/{pr_number}", headers=HEADERS, json=data)
    if response.status_code == 200:
        print(f"PR #{pr_number} 제목 및 내용 업데이트 완료.")
    else:
        print(f"PR #{pr_number} 업데이트 실패: {response.json()}")


def process_pr(pr):
    """PR을 처리하여 제목, 레이블 및 내용을 업데이트."""
    pr_title = pr["title"]
    pr_number = pr["number"]

    problem_number = ""
    problem_name = ""
    if pr_title.startswith("solve : "):
        match = re.match(r"solve : (\d+) (.+)", pr_title)
        if not match:
            print(f"PR #{pr_number}의 제목이 예상된 형식이 아닙니다. 건너뜁니다.")
            return

        problem_number, problem_name = match.groups()
    else:
        # 제목을 공백 기준으로 split
        pr_title_split = pr_title.split()

        # split된 결과가 3개 미만인 경우 건너뜀
        if len(pr_title_split) < 3:
            print(f"PR #{pr_number}의 제목이 예상된 형식이 아닙니다. 건너뜁니다.")
            return

        # 문제 번호와 문제 이름 추출
        problem_number = pr_title_split[1]  # 2번째 요소가 문제 번호
        problem_name = " ".join(pr_title_split[2:])  # 나머지 부분이 문제 이름

    problem_info = get_problem_info(problem_number)
    if not problem_info:
        return

    levels = {
        0: "U",
        1: "B5", 2: "B4", 3: "B3", 4: "B2", 5: "B1",
        6: "S5", 7: "S4", 8: "S3", 9: "S2", 10: "S1",
        11: "G5", 12: "G4", 13: "G3", 14: "G2", 15: "G1",
        16: "P1", 17: "P2", 18: "P3", 19: "P2", 20: "P1",
    }
    level = problem_info["level"]
    tags = [tag["key"] for tag in problem_info["tags"]]
    level_str = levels[level]

    # 라벨 업데이트
    for tag in tags:
        create_label(tag, f"알고리즘: {tag}")

    set_pr_labels(pr_number, tags)

    files = get_pr_files(pr_number)
    code_snippets = ""
    for file in files:
        if file["filename"].endswith(".java"):  # Java 파일만 포함
            file_content = get_file_content(file["contents_url"])
            code_snippets += f"```java\n{file_content}\n```\n\n"

    # PR 제목 및 내용 업데이트
    new_title = f"[{level_str}] {problem_number} {problem_name}"
    problem_link = f"https://www.acmicpc.net/problem/{problem_number}"
    new_body = f"""
## Problem Info
- Number : {problem_number}
- Name : {problem_name}
- Level : `{level_str}`
- tags : {', '.join(f"`{tag}`" for tag in tags)}
- link : {problem_link}

## Code
{code_snippets}

## Note
"""

    update_pr(pr_number, new_title, new_body)


def main():
    """PR 리스트를 가져와 처리."""
    page = 1
    while True:
        response = requests.get(f"{BASE_URL}/pulls?state=open&per_page=200&page={page}", headers=HEADERS)
        prs = response.json()
        if not prs:
            break
        for pr in prs:
            print(pr)
            process_pr(pr)
        page += 1


if __name__ == "__main__":
    main()
