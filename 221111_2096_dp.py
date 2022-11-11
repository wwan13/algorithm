"""
DATE: 2022.11.09
QUE NUM: 2096
QUE NAME: 내력가기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2096
"""

import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int,input().split())) for _ in range(n)]

# n = 3
# data = [[1,2,3],[4,5,6],[4,9,0]]

# n = 1
# data = [[1,2,3]]

dp = [[0,0,0] for _ in range(n)]
dp.insert(0, data[0])

for i in range(1, n):
    dp[i][0] = data[i][0] + max(dp[i-1][0], dp[i-1][1])
    dp[i][1] = data[i][1] + max(dp[i-1][0], dp[i-1][1], dp[i-1][2])
    dp[i][2] = data[i][2] + max(dp[i-1][1], dp[i-1][2])
    dp[i-1] = [0,0,0]

print(max(dp[n-1]))
dp.insert(0, data[0])
print(dp)

for i in range(1, n):
    dp[i][0] = data[i][0] + min(dp[i-1][0], dp[i-1][1])
    dp[i][1] = data[i][1] + min(dp[i-1][0], dp[i-1][1], dp[i-1][2])
    dp[i][2] = data[i][2] + min(dp[i-1][1], dp[i-1][2])

print(min(dp[n-1]))