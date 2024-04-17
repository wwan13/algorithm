"""
DATE: 2023.04.07
QUE NUM: 9084
QUE NAME: 동전
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/9084
"""
import sys

imput = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    values = list(map(int, input().split()))
    m = int(input())

    dp = [0] * (m + 1)
    dp[0] = 1

    for v in values:
        for i in range(v, m+1):
            dp[i] += dp[i - v]

    print(dp[m])


