import sys

input = sys.stdin.readline


def solution(n, data):
    return sorted(data)


def display_result(answer):
    [print(e) for e in answer]


def main():
    n = int(input())
    data = [int(input()) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()