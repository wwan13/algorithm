"""
DATE: 2022.10.16
QUE NUM: 1520
QUE NAME: 내리막길
QUE TYPE: bfs
https://www.acmicpc.net/problem/1520
"""

import sys
input = sys.stdin.readline
sys.setrecursionlimit(250000)

def dfs(data, x, y):
    if x == m-1 and y == n-1:
        return 1

    if dp[x][y] == -1:
        dp[x][y] = 0

        addList = [[1,0], [0,1], [-1,0], [0,-1]]
        for add in addList:
            new_x = x + add[0]
            new_y = y + add[1]

            if new_x < 0 or new_y < 0 or new_x >= len(data) or new_y >= len(data[0]):
                continue
            if data[new_x][new_y] < data[x][y]:
                dp[x][y] += dfs(data, new_x, new_y)

    return dp[x][y]

m, n = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(m)]
# m = 4
# n = 5
dp = [[-1] * n for _ in range(m)]

# data = [
#     [50,45,37,32,30],
#     [35,50,40,20,25],
#     [30,30,25,17,28],
#     [27,24,22,15,10]
# ]

print(dfs(data, 0, 0))