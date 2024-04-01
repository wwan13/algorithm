"""
DATE: 2022.10.12
QUE NUM: 2667
QUE NAME: 단지번호붙히기
QUE TYPE: dfs
https://www.acmicpc.net/problem/2667
"""

import sys

imput = sys.stdin.readline
result = [0]

def dfs(data, x, y, visited):
    result[0] += 1
    visited[x][y] = True

    addList = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    for add in addList:
        new_x = x + add[0]
        new_y = y + add[1]
        if new_x < 0 or new_y < 0 or new_x >= len(data) or new_y >= len(data):
            continue

        if visited[new_x][new_y] == False and data[new_x][new_y] == 1:
            dfs(data, new_x, new_y, visited)


n = int(input())
data = [list(map(int,input())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
count = 0
resultList = []

for i in range(n):
    for j in range(n):
        if data[i][j] == 1 and visited[i][j] == False:
            dfs(data, i, j, visited)
            count += 1
            resultList.append(result[0])
            result[0] =  0

print(count)
resultList.sort()
print(*resultList, sep = "\n")