import sys

input = sys.stdin.readline


def solution(n, m, data, ranges):
    dp = [[0] * (n+1) for _ in range(n+1)]

    for i in range(1, n+1):
        for j in range(1, n+1):
            dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + data[i-1][j-1]

    answer = []
    for e in ranges:
        x1, y1, x2, y2 = e
        answer.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1])

    return answer


def display_result(answer):
    [print(e) for e in answer]


def main():
    n, m = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]
    ranges = [list(map(int, input().split())) for _ in range(m)]
    answer = solution(n, m, data, ranges)
    display_result(answer)


main()