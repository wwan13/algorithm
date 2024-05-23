import sys

input = sys.stdin.readline


def solution(n, data):
    _max = max(data)

    dp = [1, 1, 1, 2, 2]
    for i in range(5, _max):
        dp.append(dp[i-1] + dp[i-5])

    [print(dp[e-1]) for e in data]


def main():
    n = int(input())
    data = [int(input()) for _ in range(n)]
    solution(n, data)


main()