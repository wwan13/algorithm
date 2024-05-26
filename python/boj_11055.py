import sys

input = sys.stdin.readline


def solution(n, data):
    dp = [0] * n
    dp[0] = data[0]

    for i in range(n):
        for j in range(i):
            if data[i] > data[j]:
                dp[i] = max(dp[i], dp[j] + data[i])
            else:
                dp[i] = max(dp[i], data[i])

    return max(dp)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = list(map(int, input().split()))
    answer = solution(n, data)
    display_result(answer)


main()