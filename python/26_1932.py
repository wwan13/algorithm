"""
DATE: 2022.10.27
QUE NUM: 1932
QUE NAME: 정수삼각형
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1932
"""

import sys
input = sys.stdin.readline

n = int(input())
triangle = [list(map(int,input().split())) for _ in range(n)]

dp = [[0] * n for _ in range(n)]
dp[0][0] = triangle[0][0]

for i in range(1, n): 
    for j in range(len(triangle[i])):
        dp[i][j] = max(dp[i-1][j] + triangle[i][j], dp[i-1][j-1] + triangle[i][j])

print(max(dp[n-1]))