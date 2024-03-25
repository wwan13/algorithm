"""
DATE: 2024.03.20
QUE NUM: 2615
QUE NAME: 오목
QUE TYPE: brute force
https://www.acmicpc.net/problem/2615
"""

import sys

input = sys.stdin.readline


def is_win(graph, target, x, y):
    moves = [(1, 0), (0, 1), (1, 1), (-1, 1)]
    for move in moves:
        count = 1
        nx = x
        ny = y
        while True:
            nx += move[0]
            ny += move[1]
            if 0 <= nx < 19 and 0 <= ny < 19 and graph[nx][ny] == target:
                count += 1

                if count == 5:
                    if 0 <= x - move[0] < 19 and 0 <= y - move[1] < 19 and graph[x - move[0]][y - move[1]] == target:
                        break
                    if 0 <= nx + move[0] < 19 and 0 <= ny + move[1] < 19 and graph[nx + move[0]][ny + move[1]] == target:
                        break
                    return True
            else:
                break

    return False


def solution():
    data = []
    for _ in range(19):
        data.append(list(map(int, input().split())))

    for i in range(19):
        for j in range(19):
            if data[i][j] == 0:
                continue

            target = data[i][j]
            if is_win(data, target, i, j):
                print(target)
                print("{} {}".format(i+1, j+1))
                return

    print("0")


solution()
