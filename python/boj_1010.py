import sys
import math

input = sys.stdin.readline


def solution(n, m):
    return math.factorial(m) // (math.factorial(n) * math.factorial(m-n))


def display_result(answer):
    print(answer)


def main():
    t = int(input())
    for _ in range(t):
        n, m = map(int, input().split())
        answer = solution(n, m)
        display_result(answer)


main()
