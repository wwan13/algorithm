import os
import requests


def get_files_by_language(language):
    languages = {
        "python": "./python",
        "java": "./java/src"
    }

    return os.listdir(languages[language])


def get_problem_info(problem_id):
    levels = {
        0: "U",
        1: "B5", 2: "B4", 3: "B3", 4: "B2", 5: "B1",
        6: "S5", 7: "S4", 8: "S3", 9: "S2", 10: "S1",
        11: "G5", 12: "G4", 13: "G3", 14: "G2", 15: "G1",
        16: "P1", 17: "P2", 18: "P3", 19: "P2", 20: "P1",
    }

    response = requests.get("https://solved.ac/api/v3/problem/show?problemId={}".format(problem_id)).json()

    return {
        "problem_id": response["problemId"],
        "problem_name": response["titleKo"],
        "problem_level": levels[response["level"]],
        "problem_tag": response["tags"][0]["key"],
    }


def get_solved_info(fileNmae):
    if fileNmae.startswith("boj_"):
        return {
            "problem_number": fileNmae.split("_")[1].split(".")[0],
            "language": "python"
        }

    if fileNmae.startswith("Boj"):
        return {
            "problem_number": fileNmae.split("Boj")[1].split(".")[0],
            "language": "java"
        }

    return {
            "problem_number": fileNmae,
            "language": "none"
        }


def create_markdown_file():
    if os.path.isfile("../README.md"):
        os.remove("../README.md")

    readme = open("../README.md", "w")

    readme.write("<div align=\"center\">  \n\n")
    readme.write("![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=OpenJDK&logoColor=white)\n")
    readme.write("![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)  \n")
    readme.write("[![Solved.ac Profile](http://mazassumnida.wtf/api/v2/generate_badge?boj=wwan13)](https://solved.ac//)<br>\n\n")
    readme.write("</div>\n\n")

    readme.write("| NUM |  ID  | RANK | NAME | TAG | LANGUAGE |\n")
    readme.write("|:---:|:----:|:----:|:----:|:---:|:---:|\n")

    index = 0

    files = get_files_by_language("python") + get_files_by_language("java")
    for file in files:
        if file.startswith("boj_") or file.startswith("Boj"):
            index += 1
            row_format = "|  {}  |  {}  |  {}  |  {}  |  {}  |  {}  |\n"
            problem_number = get_solved_info(file)["problem_number"]
            problem_info = get_problem_info(problem_number)

            readme.write(row_format.format(
                index,
                problem_number,
                problem_info["problem_name"],
                problem_info["problem_level"],
                problem_info["problem_tag"],
                get_solved_info(file)["language"],
            ))

    readme.close()


def main():
    create_markdown_file()


main()
