"""
DATE: 2022.11.02
QUE NUM: 1149
QUE NAME: 1로만들기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1149
"""

n = int(input())

dp = [0] * (n+1)

for i in range(2, n+1):
    dp[i] = dp[i-1] + 1

    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i//2]+1)
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp.pop())