"""
DATE: 2022.10.19
QUE NUM: 2437
QUE NAME: 저울
QUE TYPE: greedy
https://www.acmicpc.net/problem/2437
"""

import sys
input = sys.stdin.readline

# 입력
n = int(input())
data = list(map(int, input().split()))
data.sort()

target = 1
for i in data:
    if target < i:
        break
    target += i

print(target)
