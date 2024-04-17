"""
DATE: 2024.03.22
QUE NUM: 14719
QUE NAME: 빗물
QUE TYPE: implementation
https://www.acmicpc.net/problem/14719
"""

import sys

input = sys.stdin.readline


def solution():
    h, w = map(int, input().split())
    blocks = list(map(int, input().split()))

    answer = 0
    for i in range(1, h+1):
        can_count = False
        count = 0
        for j in range(w):
            if i <= blocks[j]:
                can_count = True

            if can_count:
                if i <= blocks[j]:
                    answer += count
                    count = 0
                if i > blocks[j]:
                    count += 1

    print(answer)


solution()