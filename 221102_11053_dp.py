"""
DATE: 2022.11.02
QUE NUM: 11053
QUE NAME: 가장 긴 증가하는 부분수열
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/11053
"""

import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))

# n = 6
# data = [10, 20, 10, 30, 20, 50]
dp = [1] * n

for i in range(n):
    for j in range(i):
        if data[i] > data[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp))
