"""
DATE: 2023.04.14
QUE NUM: 15486
QUE NAME: 퇴사 2
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/15486
"""
import sys
input = sys.stdin.readline

n = int(input())
t = [0] * (n+1)
p = [0] * (n+1)
for i in range(n):
    t[i], p[i] = map(int, input().split())

dp = [0] * (n+1)
_max = 0

for i in range(n):
    _max = max(_max, dp[i])
    if i + t[i] > n:
        continue
    dp[i + t[i]] = max(_max + p[i], dp[i+t[i]])

print(max(dp))