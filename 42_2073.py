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

dp = [100001] + [0] * d

for i in range(1, p+1):
    l, c = map(int, input().split())
    