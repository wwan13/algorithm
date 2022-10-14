"""
DATE: 2022.10.13
QUE NUM: 1012
QUE NAME: 유기농배추
QUE TYPE: dfs
https://www.acmicpc.net/problem/1012
"""

import sys
from unittest import result
input = sys.stdin.readline

def dfs(data, x, y, visited):
    visited[x][y] = True
    print("a")

    addList = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    for add in addList:
        new_x = x + add[0]
        new_y = y + add[1]

        if new_x < 0 or new_y < 0 or new_x >= len(data) or new_y >= len(data[0]):
            continue
        if visited[new_x][new_y] == False and data[new_x][new_y] == 1:
            dfs(data, new_x, new_y, visited)

t = int(input())
for _ in range(t):
    m, n, k = map(int, input().split())
    data = [[0] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]

    for i in range(k):
        x, y = map(int, input().split())
        data[y][x] = 1

    result = 0
    print()
    for i in range(n):
        for j in range(m):
            print(i, j)
            if visited[i][j] == False and data[i][j] == 1:
                result += 1
                dfs(data, x, y, visited)

    print(result)