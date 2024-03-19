"""
DATE: 2024.03.10
QUE NUM: 14620
QUE NAME: 꽃길
QUE TYPE: brute force
https://www.acmicpc.net/problem/14620
"""

import sys
from itertools import combinations

input = sys.stdin.readline


def solution():
    n = int(input())
    data = []
    for _ in range(n):
        data.append(list(map(int, input().split())))

    positions = []
    result = int(1e9)

    for i in range(1, n-1):
        for j in range(1, n-1):
            positions.append((i, j))

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for elements in combinations(positions, 3):
        visited = [[False] * n for _ in range(n)]
        duplicated = False
        price = 0
        for element in elements:
            x, y = element
            if visited[x][y]:
                duplicated = True
                break
            price += data[x][y]
            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]
                if visited[nx][ny]:
                    duplicated = True
                    break
                price += data[nx][ny]
                visited[nx][ny] = True
        if not duplicated:
            result = min(price, result)

    print(result)


solution()
