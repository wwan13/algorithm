"""
DATE: 2022.11.05
QUE NUM: 1904
QUE NAME: 01타일
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1904
"""

import sys
input = sys.stdin.readline

n = int(input())

dp = [1, 2]
for i in range(2, n):
    # 미리미리 나머지 계산을 해줘야 메모리 오버가 나지 않음
    # 수가 커지면 int 의 용량보다 커져서 메모리를 많이 차지함
    dp.append((dp[i-2] + dp[i-1]) % 15746)

print(dp[n-1])
