import sys

input = sys.stdin.readline


def solution(n):
    dp = [0, 1, 2, 3]
    for i in range(4, n+1):
        dp.append((dp[i-1] + dp[i-2]) % 10007)
    return dp[n]


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()