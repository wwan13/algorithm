"""
DATE: 2024.03.22
QUE NUM: 1158
QUE NAME: 요세푸스 문제
QUE TYPE: implementation
https://www.acmicpc.net/problem/1158
"""

import sys

input = sys.stdin.readline


def solution():
    n, k = map(int, input().split())
    people = [i+1 for i in range(n)]

    index = 0
    result = []
    while len(people) > 0:
        index = (index + k - 1) % n
        result.append(format(people.pop(index)))
        n -= 1

    print("<", ", ".join(result)[:], ">", sep='')


solution()
