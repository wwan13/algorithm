"""
DATE: 2022.11.09
QUE NUM: 2096
QUE NAME: 내력가기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2096
"""

import sys
input = sys.stdin.readline

n = int(input())
first_data = list(map(int, input().split()))

if n == 1:
    print(max(first_data), min(first_data))
    sys.exit()

dp_max = [0, 0, 0]
dp_min = [0, 0, 0]
max_tmp = first_data.copy()
min_tmp = first_data.copy()

for i in range(n-1):
    data = list(map(int, input().split()))
    dp_max[0] = data[0] + max(max_tmp[0], max_tmp[1])
    dp_max[1] = data[1] + max(max_tmp[0], max_tmp[1], max_tmp[2])
    dp_max[2] = data[2] + max(max_tmp[1], max_tmp[2])
    max_tmp = dp_max.copy()

    dp_min[0] = data[0] + min(min_tmp[0], min_tmp[1])
    dp_min[1] = data[1] + min(min_tmp[0], min_tmp[1], min_tmp[2])
    dp_min[2] = data[2] + min(min_tmp[1], min_tmp[2])
    min_tmp = dp_min.copy()
 
print(max(dp_max), min(dp_min))