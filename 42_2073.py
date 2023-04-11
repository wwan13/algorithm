"""
DATE: 2023.04.10
QUE NUM: 2073
QUE NAME:수도배관공사
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2073
"""

import sys
input = sys.stdin.readline

d, p = map(int, input().split())
dp = [1e9] + [0] * d                                        # dp 초기회
for i in range(p):
    l, c = map(int, input().split())
    dp_max = dp.copy()
    for i in range(l, d+1):
        if dp_max[i-l] :
            dp[i] = max(dp[i], min(dp_max[i-l], c))

print(dp[d])