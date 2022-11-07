"""
DATE: 2022.11.07
QUE NUM: 2146
QUE NAME: 포도주 시식
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2156
"""

import sys
input = sys.stdin.readline

n = int(input())
data = [0] * 10000
for i in range(n):
    data[i] = int(input())

dp = [0] * 10000

dp[0] = data[0]
dp[1] = data[0] + data[1]
dp[2] = max(data[0] + data[2], data[1] + data[2], dp[1])
for i in range(3, n):
    dp[i] = max(dp[i-2] + data[i], dp[i-1], data[i] + data[i-1] + dp[i-3])

print(max(dp))