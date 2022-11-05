"""
DATE: 2022.11.05
QUE NUM: 11052
QUE NAME: 카드 구매하기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/11052
"""

import sys
input = sys.stdin.readline

n = int(input())
pay = list(map(int, input().split()))

pay.insert(0,0)
dp = [0] * (n+1)

for i in range(1, n+1):
    for j in range(1, i+1):
        dp[i] = max(dp[i], pay[j] + dp[i-j])

print(dp[n])