"""
DATE: 2022.11.09
QUE NUM: 2565
QUE NAME: 전깃줄
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2565
"""

import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]

data.sort(key = lambda x:x[0])
dp = [1] * n

# 가장 긴 증가하는 부분수열 찾기
for i in range(n):
    for j in range(i):
        if data[i][1] > data[j][1]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))