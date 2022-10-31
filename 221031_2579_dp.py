"""
DATE: 2022.10.27
QUE NUM: 1149
QUE NAME: RGB거리
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1149
"""

# n = int(input())
# stair = [int(input) for _ in range(n)]

import sys
sys.stdin.readline

n = int(input())
data = [int(input()) for _ in range(n)]
dp = []

if n==1:
    print(data[0])
elif n==2:
    print(data[0] + data[1])
else:
    dp.append(data[0])
    dp.append(max(data[0] + data[1], data[1]))
    dp.append(max(data[0] + data[2], data[1] + data[2]))
    for i in range(3,n+1):
        dp.append(max(dp[i-2] + data[i], dp[i-3] + data[i] + data[i-1]))

    print(dp.pop())



