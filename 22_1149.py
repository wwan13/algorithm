"""
DATE: 2022.10.27
QUE NUM: 1149
QUE NAME: RGB거리
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1149
"""

import sys
input = sys.stdin.readline

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    data[i][0] += min(data[i-1][1], data[i-1][2])
    data[i][1] += min(data[i-1][0], data[i-1][2])
    data[i][2] += min(data[i-1][0], data[i-1][1])

result = min(data[n-1])
print(result)