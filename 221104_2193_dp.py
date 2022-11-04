"""
DATE: 2022.11.04
QUE NUM: 2193
QUE NAME: 이친수
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2193
"""

import sys
input = sys.stdin.readline

n = int(input())
dp = [0,1,1]

for i in range(3,91):
    dp.append(dp[i-2] + dp[i-1])

print(dp[n])