"""
DATE: 2022.10.25
QUE NUM: 16236
QUE NAME: 아기상어
QUE TYPE: bfs
https://www.acmicpc.net/problem/16236
"""

import sys
from collections import deque
from copy import deepcopy

input = sys.stdin.readline
dxdy = [[0,1], [-1,0], [1,0], [0,-1]]

class Shark:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.level = 2
        self.experience = 0

class Fish:
    def __init__(self, x, y, distance):
        self.x = x
        self.y = y
        self.distance = distance


# 먹을 수 있는 물고기중 가장 가까운 물고기를 찾는 함수, 없으면 false를 반환
def find_closest_fish(shark):
    queue = deque([[shark.x, shark.y]])
    visited = [[False] * n for _ in range(n)]
    tmp_data = deepcopy(data)
    eatable_fish_list = []

    while queue:
        x1, y1 = map(int, queue.popleft())
        visited[x1][y1] = True

        for x,y in dxdy:
            new_x = x1 + x
            new_y = y1 + y

            # 위치 초과 처리
            if new_x < 0 or new_x >= n or new_y < 0 or new_y >= n:
                continue

            if tmp_data[new_x][new_y] <= shark.level and visited[new_x][new_y] == False:
                queue.append([new_x,new_y])
                visited[new_x][new_y] = True

                if tmp_data[new_x][new_y] < shark.level and tmp_data[new_x][new_y] != 0:
                    distance = abs(shark.x - new_x) + abs(shark.y - new_y)
                    fish = Fish(new_x, new_y, distance)
                    eatable_fish_list.append(fish)
                    tmp_data[new_x][new_y] = 0

    if len(eatable_fish_list) == 0:
        return False
    else:
        eatable_fish_list.sort(key=lambda x: (x.distance, x.x, x.y))
        return eatable_fish_list[0]

n = 4
data = [[4,3,2,1], [0,0,0,0], [0,0,9,0], [1,2,3,4]]

shark_x, shark_y = map(int,[(i,j) for i in range(n) for j in range(n) if data[i][j]==9][0])
shark = Shark(shark_x, shark_y)
time = 0 # 소요 시간

while(True):
    fish = find_closest_fish(shark)
    if fish == False:
        break
    
    time += fish.distance

    shark.experience += 1

    if shark.experience >= shark.level:
        shark.level += 1
        shark.experience = 0
    
    shark.x = fish.x
    shark.y = fish.y

    data[fish.x][fish.y] = 0

print(time)
