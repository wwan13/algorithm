"""
DATE: 2022.10.19
QUE NUM: 2437
QUE NAME: 저울
QUE TYPE: greedy
https://www.acmicpc.net/problem/2437
"""

import sys
from itertools import combinations
input = sys.stdin.readline

# 입력

# n = int(input())
# data = list(map(int, input().split()))

n = 7
data = [3, 1, 6, 2, 7, 30, 1]

data.sort()
# array = [0] * (sum(data) + 1)
array = []

# 갯수만큼 반복
for i in range(1, len(data)+1):
    # 모든 조합의 경우에수에 대해
    for d in list(combinations(data, i)):
        # array[sum(d)] = 1
        if sum(d) not in array:
            array.append(sum(d))

array.sort()

result = 0
for i in range(1, sum(data)+1):
    if i not in array:
        result = i
        break

print(result)
