"""
DATE: 2023.04.14
QUE NUM: 2493
QUE NAME: 탑
QUE TYPE: Data structure
https://www.acmicpc.net/problem/2493
"""

import sys
input = sys.stdin.readline

n = int(input())
tower = [0] + list(map(int, input().split()))
result = [0] * (n+1)
stack = []

for i in range(1, n+1):
    while stack:
        if tower[i] > stack[-1][0]:
            stack.pop()
        else:
            result[i] = stack[-1][1]
            break

    stack.append((tower[i], i))

for i in range(1, n+1):
    print(result[i], end=" ")