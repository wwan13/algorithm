"""
DATE: 2023.04.12
QUE NUM: 21317
QUE NAME: 징검다리 건너기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/21317
"""

import sys
input = sys.stdin.readline

n = int(input())
stairs = [0] + [int(input()) for _ in range(n)]

if n <= 2:
    print(sum(stairs))
    exit()

dp = [0] * (n+1)
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]

for i in range(3, n+1):
    dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i])

print(dp[n])