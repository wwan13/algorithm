import sys

input = sys.stdin.readline


def solution(n, data):
    dp = [-1e9 for _ in range(n)]
    dp[0] = data[0]
    for i in range(1, n):
        dp[i] = max(data[i], dp[i-1] + data[i])

    return max(dp)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = list(map(int, input().split()))
    answer = solution(n, data)
    display_result(answer)


main()