import sys

input = sys.stdin.readline


def solution(n, data):
    answer = sorted(data, key=lambda x: (x[0], x[1]))
    return answer


def display_result(answer):
    [print(e[0], e[1]) for e in answer]


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()