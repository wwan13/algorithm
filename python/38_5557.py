"""
DATE: 2023.04.05
QUE NUM: 5557
QUE NAME: 1학년
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/5557
"""

import sys

input= sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))

dp = [[0]*21 for i_ in range (n-1)]

dp[0][data[0]] = 1

prev_data = 0
next_data = 0

for i in range(1, n-1):
    for j in range(21):
        if dp[i-1][j] != 0:
            prev_data = j
            next_data = data[i]

            if 0 <= prev_data + next_data <= 20 :
                dp[i][prev_data + next_data] += dp[i-1][prev_data]
            if 0 <= prev_data - next_data <= 20 :
                dp[i][prev_data - next_data] += dp[i-1][prev_data]

print(dp[n-2][data[n-1]])