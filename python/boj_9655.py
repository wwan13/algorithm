import sys

input = sys.stdin.readline


def solution(n):
    result = {1: "SK", 0: "CY"}
    return result[n % 2]


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()