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
data = [[] for _ in range(n)]
for i in range(3):
    r, g, b = map(int, input().split())
    data[0].append(r)
    data[1].append(g)
    data[2].append(b)

