import sys

input = sys.stdin.readline


def solution(n, m, data):
    dp = [[0 for _ in range(m+1)] for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, m+1):
            dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + data[i-1][j-1]

    return dp[-1][-1]


def display_result(answer):
    print(answer)


def main():
    n, m = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, m, data)
    display_result(answer)


main()