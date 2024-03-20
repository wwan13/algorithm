"""
DATE: 2024.03.20
QUE NUM: 2961
QUE NAME: 도영이가 만든 맛있는 음식
QUE TYPE: brute force
https://www.acmicpc.net/problem/2961
"""

import sys
from itertools import combinations

input = sys.stdin.readline


def solution():
    n = int(input())
    data = []
    for _ in range(n):
        data.append(list(map(int, input().split())))

    result = int(1e9)
    for i in range(1, n+1):
        for elements in combinations(data, i):
            sour = 1
            bitter = 0
            for element in elements:
                sour *= element[0]
                bitter += element[1]
            result = min(result, abs(sour - bitter))

    print(result)


solution()
