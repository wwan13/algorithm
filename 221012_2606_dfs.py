"""
DATE: 2022.10.12
QUE NUM: 2606
QUE NAME: 바이러스
QUE TYPE: dfs
https://www.acmicpc.net/problem/2606
"""

import sys
from unittest import result
input = sys.stdin.readline

result = [0]
def dfs(graph, v, visited):
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            result[0] += 1
            dfs(graph, i, visited)

computers = int(input())
pairs = int(input())

graph = [[] for _ in range(computers+1)]
visited = [False] * (computers + 1)

for _ in range(pairs):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(graph, 1, visited)
print(result[0])