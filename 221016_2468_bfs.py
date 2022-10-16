"""
DATE: 2022.10.16
QUE NUM: 2468
QUE NAME: 안전영역
QUE TYPE: bfs
https://www.acmicpc.net/problem/2468
"""

import sys
from collections import deque
input = sys.stdin.readline

def bfs(data, x, y, t, visited):
    visited[x][y] = True
    queue = deque([[x,y]])

    addList = [[1,0], [0,1], [-1,0], [0,-1]]
    while queue:
        x1, y1 = map(int, queue.popleft())
        
        for add in addList:
            new_x = x1 + add[0]
            new_y = y1 + add[1]

            if new_x < 0 or new_y < 0 or new_x >= len(data[0]) or new_y >= len(data):
                continue
            if data[new_x][new_y] > t and visited[new_x][new_y] == False:
                visited[new_x][new_y] = True
                queue.append([new_x, new_y])

n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]

max_value = max(map(max, data))

resultList = []
for k in range(max_value):
    visited = [[False] * n for _ in range(n)]
    result = 0
    for i in range(n): 
        for j in range(n):
            if data[i][j] > k and visited[i][j] == False:
                bfs(data, i, j, k, visited)
                result += 1
    resultList.append(result)

print(max(resultList))
