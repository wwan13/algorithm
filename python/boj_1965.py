import sys

input = sys.stdin.readline


def solution(n, data):
    dp = [1 for _ in range(n)]

    for i in range(n):
        for j in range(i):
            if data[j] < data[i]:
                dp[i] = max(dp[j] + 1, dp[i])

    return max(dp)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = list(map(int, input().split()))
    answer = solution(n, data)
    display_result(answer)


main()