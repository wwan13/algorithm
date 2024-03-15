"""
DATE: 2024.03.15
QUE NUM: 16918
QUE NAME: 봄버맨
QUE TYPE: graph traversal
https://www.acmicpc.net/problem/16918
"""

import sys

input = sys.stdin.readline


def bfs(state, visited):
    bomb_range = [(0, -1), (1, 0), (0, 1), (-1, 0)]
    for i in range(len(state)):
        for j in range(len(state[i])):
            if state[i][j] == 'O':
                state[i][j] = '*'
                for cursor in bomb_range:
                    x, y = cursor
                    if 0 <= i + x < len(state) and 0 <= j + y < len(state[i]):
                        if state[i + x][j + y] != 'O':
                            state[i + x][j + y] = '*'

    for i in range(len(state)):
        for j in range(len(state[i])):
            if state[i][j] == '*':
                state[i][j] = '.'
            elif state[i][j] == '.':
                state[i][j] = 'O'


def display_result(result):
    for i in range(len(result)):
        for j in range(len(result[i])):
            print(result[i][j], end='')
        print()


def solution():
    r, c, n = map(int, input().split())
    empty_state = []
    state = []

    for i in range(r):
        state.append(list(input().strip()))
        empty_state.append(['O' for _ in range(c)])

    if n % 2 == 0:
        display_result(empty_state)
        exit()

    for i in range(3, n+1, 2):
        visited = [['O' for _ in range(c)] for _ in range(r)]
        bfs(state, visited)

    display_result(state)


solution()
