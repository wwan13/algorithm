"""
DATE: 2023.04.06
QUE NUM: 5557
QUE NAME: 함꼐 블록 쌓기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/5557
"""
import sys

input = sys.stdin.readline

N, M, H = map(int, input().split())

dp = [[1] + [0] * H for i in range(N+1)]

for i in range(1, N+1):
    dp[i] = dp[i-1].copy()
    blocks = list(map(int, input().split()))

    for block in blocks:
        for j in range(block, H+1):
            dp[i][j] += dp[i-1][j - block]

print(dp[N][H] % 10007)