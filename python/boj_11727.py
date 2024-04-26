import sys

input = sys.stdin.readline


def solution(n):
    dp = [1, 3]
    for i in range(len(dp), n):
        dp.append(dp[i-1] + (2 * dp[i-2]))

    return dp[n-1] % 10007


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()