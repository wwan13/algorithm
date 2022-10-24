"""
DATE: 2022.10.25
QUE NUM: 16236
QUE NAME: 아기상어
QUE TYPE: bfs
https://www.acmicpc.net/problem/16236
"""

import sys
from collections import deque
input = sys.stdin.readline

# 먹을 수 있는 물고기중 가장 가까운 물고기를 찾는 함수, 없으면 false를 반환
def find_closest_fish(shark_x, shark_y, shark_level):
    queue = deque([[shark_x, shark_y]])
    visited = [[False] * n for _ in range(n)]
    dxdy = [[0,1], [-1,0], [1,0], [0,-1]]
    while queue:
        x1, y1 = map(int, queue.popleft())
        visited[x1][y1] = True
        for x,y in dxdy:
            new_x = x1 + x
            new_y = y1 + y

            if new_x < 0 or new_x >= n or new_y < 0 or new_y >= n:
                continue
            if data[new_x][new_y] <= shark_level and visited[new_x][new_y] == False:
                queue.append([new_x,new_y])
                visited[new_x][new_y] = True
                if data[new_x][new_y] < shark_level and data[new_x][new_y] != 0:
                    return new_x, new_y
    return False

# n = int(input())
# data = [list(map(int, input().split())) for _ in range(n)]
# n = 4
# data = [[4,3,2,1], [0,0,0,0], [0,0,9,0], [1,2,3,4]]
# data = [[0,0,0,0], [0,0,0,0], [0,0,9,0], [0,0,0,0]
n = 6
data = [[5,4,3,2,3,4], [4,3,2,3,4,5], [3,2,9,5,6,6], [2,1,2,3,4,5], [3,2,1,6,5,4], [6,6,6,6,6,6]]

print(*data, sep="\n")

shark_level = 2
shark_y, shark_x = map(int,[(i,j) for i in range(n) for j in range(n) if data[i][j]==9][0])
time = 0 # 소요 시간
experience = 0 # 경험치

print(shark_x,shark_y)
x, y = find_closest_fish(shark_x, shark_y, shark_level)
# print(x,y)

while(True):
    if find_closest_fish(shark_x, shark_x, shark_level) == False:
        break

    # 먹을 수 있는 가장 가까운 물고기를 찾음
    fish_x, fish_y = find_closest_fish(shark_x, shark_y, shark_level)
    print(fish_x,fish_y)
    # 거리 계산 후 시간에 더함
    distance = abs(shark_x - fish_x) + abs(shark_y - fish_y)
    time += distance
    experience += 1
    # 먹은 물고기는 없애버림
    data[fish_x][fish_y] = 0
    shark_x = fish_x
    shark_y = fish_y

    # 레벨업
    if experience >= shark_level:
        shark_level += 1
        experience = 0

print(time)