"""
DATE: 2023.10.05
QUE NUM: 10819
QUE NAME: 차이를 최대호
https://www.acmicpc.net/problem/10819
"""

import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

max_result = -1e9
for i in permutations(arr):
    result = 0
    for j in range(0, n-1):
        result += abs(i[j+1] - i[j])
    max_result = max(max_result, result)

print(max_result)