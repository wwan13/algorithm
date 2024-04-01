"""
DATE: 2024.03.22
QUE NUM: 16234
QUE NAME: 인구 이동
QUE TYPE: graph traversal
https://www.acmicpc.net/problem/16234
"""

import sys

input = sys.stdin.readline


def can_move(graph, n, left, right):
    unite = [[0] * n for _ in range(n)]

    unite_num = 1

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    count = dict()
    sum = dict()
    unite_count = 0

    for x in range(n):
        for y in range(n):
            if unite[x][y] == 0:
                unite[x][y] = unite_num
                unite_num += 1
                sum[unite[x][y]] = graph[x][y]
                count[unite[x][y]] = 1

            for k in range(4):
                nx = x + dx[k]
                ny = y + dy[k]

                if 0 <= nx < n and 0 <= ny < n:
                    if left <= abs(graph[nx][ny] - graph[x][y]) <= right:
                        unite_count += 1
                        unite[nx][ny] = unite[x][y]
                        sum[unite[nx][ny]] += graph[nx][ny]
                        count[unite[nx][ny]] += 1

    if unite_count == 0:
        return False

    for key in sum.keys():
        sum[key] //= count[key]

    for i in range(n):
        for j in range(n):
            if unite[i][j] != 0:
                graph[i][j] = sum[unite[i][j]]
    print(graph)
    return True


def solution():
    n, l, r = map(int, input().split())
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))

    count = 0
    while can_move(graph, n, l, r):
        count += 1

    print(count)


solution()
