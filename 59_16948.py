"""
DATE: 2024.03.18
QUE NUM: 16948
QUE NAME: 데스 나이트
QUE TYPE: graph traversal
https://www.acmicpc.net/problem/16948
"""

import sys
from collections import deque

input = sys.stdin.readline


def bfs(n, fx, fy, tx, ty):
    visited = [[False] * n for _ in range(n)]
    result = [[0] * n for _ in range(n)]

    dx = [-2, -2, 0, 0, 2, 2]
    dy = [-1, 1, -2, 2, -1, 1]

    queue = deque()
    queue.append((fx, fy))

    visited[fx][fy] = True
    result[fx][fy] += 1

    while queue:
        x, y = queue.popleft()
        for i in range(6):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx == tx and ny == ty:
                return result[x][y]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                result[nx][ny] = result[x][y] + 1
                visited[nx][ny] = True
                queue.append((nx, ny))

    return -1


def solution():
    n = int(input())
    fx, fy, tx, ty = map(int, input().split())

    print(bfs(n, fx, fy, tx, ty))


solution()
