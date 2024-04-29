import sys

input = sys.stdin.readline


def solution(n):
    dp = [-1, -1, -1, 1, -1, 1]
    for i in range(6, n+1):
        if dp[i-3] == -1 and dp[i-5] == -1:
            dp.append(-1)
            continue

        if dp[i-3] == -1 or dp[i-5] == -1:
            dp.append(max(dp[i-3], dp[i-5]) + 1)
            continue

        dp.append(min(dp[i - 3], dp[i - 5]) + 1)

    return dp[n]


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()