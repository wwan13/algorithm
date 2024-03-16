"""
DATE: 2024.03.16
QUE NUM: 14940
QUE NAME: 쉬운 최단거리
QUE TYPE: graph traversal
https://www.acmicpc.net/problem/14940
"""

import sys
from collections import deque

input = sys.stdin.readline


def bfs(input_map, x, y, visited, result):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]

    queue = deque()
    queue.append((x, y))

    visited[x][y] = True
    result[x][y] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(input_map) and 0 <= ny < len(input_map[i]) and not visited[nx][ny]:
                if input_map[nx][ny] == 0:
                    visited[nx][ny] = True
                    result[nx][ny] = 0
                elif input_map[nx][ny] == 1:
                    visited[nx][ny] = True
                    result[nx][ny] = result[x][y] + 1
                    queue.append((nx, ny))


def solution():
    n, m = map(int, input().split())
    input_map = [[] for _ in range(n)]
    result = [[-1] * m for _ in range(n)]
    start_x = None
    start_y = None

    for i in range(n):
        input_map[i] = list(map(int, input().split()))
        if 2 in input_map[i]:
            start_x = i
            start_y = input_map[i].index(2)

    visited = [[False for _ in range(m)] for _ in range(n)]
    bfs(input_map, start_x, start_y, visited, result)

    for i in range(n):
        for j in range(m):
            if input_map[i][j] == 0:
                print(0, end=' ')
                continue
            print(result[i][j], end=' ')
        print()


solution()
