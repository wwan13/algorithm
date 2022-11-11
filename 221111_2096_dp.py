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
data = [list(map(int,input().split())) for _ in range(n)]

# n = 3
# data = [[1,2,3],[4,5,6],[4,9,0]]

# n = 1
# data = [[1,2,3]]

dp_max = [[0,0,0] for _ in range(n-1)]
dp_max.insert(0, data[0])

dp_min = [[0,0,0] for _ in range(n)]
dp_min.insert(0, data[0])

for i in range(1, n):
    dp_max[i][0] = data[i][0] + max(dp_max[i-1][0], dp_max[i-1][1])
    dp_max[i][1] = data[i][1] + max(dp_max[i-1][0], dp_max[i-1][1], dp_max[i-1][2])
    dp_max[i][2] = data[i][2] + max(dp_max[i-1][1], dp_max[i-1][2])

    dp_min[i][0] = data[i][0] + min(dp_min[i-1][0], dp_min[i-1][1])
    dp_min[i][1] = data[i][1] + min(dp_min[i-1][0], dp_min[i-1][1], dp_min[i-1][2])
    dp_min[i][2] = data[i][2] + min(dp_min[i-1][1], dp_min[i-1][2])

print(max(dp_max[n-1]))
print(min(dp_min[n-1]))