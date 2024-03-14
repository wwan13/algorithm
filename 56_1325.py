"""
DATE: 2024.03.14
QUE NUM: 1325
QUE NAME: 효율적인 해킹
QUE TYPE: graph traversal
https://www.acmicpc.net/problem/1325
"""

import sys
from collections import deque

input = sys.stdin.readline


def bfs(graph, n, visited, counts):
    queue = deque([n])
    visited[n] = True
    count = 1

    while queue:
        x = queue.popleft()
        for i in graph[x]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                count += 1

    if count not in counts.keys():
        counts[count] = []

    counts[count].append(n)


def solution():
    n, m = map(int, input().split())
    graph = [[] for _ in range(n+1)]

    for i in range(m):
        a, b = map(int, input().split())
        graph[b].append(a)

    print(graph)
    counts = dict()
    for i in range(1, n+1):
        visited = [False] * (n+1)
        bfs(graph, i, visited, counts)

    print(counts)
    max_count = max(counts)
    result = counts[max_count].copy()
    print(*sorted(result))


solution()
