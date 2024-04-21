import sys

input = sys.stdin.readline


def solution(n):
    answer = list()
    for i in range(1, n+1):
        isAnswer = True
        words = list(map(int, str(i).rstrip()))

        for j in range(len(words) - 2):
            if words[j + 1] - words[j] != words[j + 2] - words[j + 1]:
                isAnswer = False
                break

        if isAnswer:
            answer.append(i)

    return len(answer)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()