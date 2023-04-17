"""
DATE: 2023.04.16
QUE NUM: 1106
QUE NAME: 호텔
QUE TYPE: Dynamic Programming
https://www.acmicpc.net/problem/1106
"""

import sys
input = sys.stdin.readline

c, n = map(int, input().split())

dp = [1e9] * (c+1)

for i in range(1, n+1):
    cost, customer = map(int, input().split())
    dp[customer] = cost

for i in range(c+1):
    for j in range(i+1):
        if i + j < c:
            dp[i+j] = min(dp[i+j], dp[i] + dp[j])
        elif i + j >= c:
            dp[c] = min(dp[c], dp[i] + dp[j])

print(dp[c])