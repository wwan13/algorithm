"""
DATE: 2022.10.19
QUE NUM: 2470
QUE NAME: 두 용액
QUE TYPE: sorting
https://www.acmicpc.net/problem/2470
"""

import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
data.sort()

# 최초 데이터 설졍
left = 0
right = n-1
min = abs(data[0] + data[1])
resultData = [0,0]

# 모든 데이터에 대해
while left < right:
    d_left = data[left]
    d_right = data[right]

    sum = d_left + d_right

    if abs(sum) <= min:
        min = abs(sum)
        resultData = [d_left, d_right]

    if sum < 0:
        left += 1
    else:
        right -= 1

print(resultData[0], resultData[1])