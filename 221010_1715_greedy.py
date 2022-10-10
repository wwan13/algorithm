"""
DATE: 2022.10.10
QUE NUM: 1715
QUE NAME: 카드정렬하기
QUE TYPE: greedy
https://www.acmicpc.net/problem/1715
"""

import heapq

n = int(input())
data = list()
for i in range(n):
    heapq.heappush(data, int(input()))

result = 0
for i in range(n-1):
    min1 = heapq.heappop(data)
    min2 = heapq.heappop(data)
    result += min1 + min2
    heapq.heappush(data, min1 + min2)

print(result)