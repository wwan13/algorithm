"""
DATE: 2023.04.12
QUE NUM: 21317
QUE NAME: 징검다리 건너기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/21317
"""

import sys
input = sys.stdin.readline

n = int(input())
energies = [[0,0]] + [list(map(int, input().split())) for _ in range(n-1)]
k = int(input())

dp = [0] * (n+1)

if n==1:
    print(0)
elif n==2:
    print(energies[1][0])
else:
    dp[2] = energies[1][0]
    dp[3] = min(dp[2] + energies[2][0], energies[1][1])

    for i in range(4, n+1):
        dp[i] = min(dp[i-1] + energies[i-1][0], dp[i-2] + energies[i-2][1])

    _min = dp[-1]
    for i in range(1, n-2):
        dp_copy = dp.copy()
        print(dp_copy)

        if dp_copy[i] + k < dp_copy[i+3]:
            dp_copy[i+3] = dp_copy[i] + k

            for j in range(i+4, n+1):
                dp_copy[j] = min(dp_copy[j], dp_copy[j-1] + dp[j-1][0], dp_copy[j-2] + dp[j-2][1])

            if _min > dp_copy[-1]:
                _min = dp_copy[-1]

    print(_min)