"""
DATE: 2023.10.05
QUE NUM: 1107
QUE NAME: 리모컨
https://www.acmicpc.net/problem/1107
"""

import sys
input = sys.stdin.readline

target_channel = int(input())
n = int(input())
if n:
    broken_buttons = list(input().split())
else:
    broken_buttons = []
current_channel = 100

count = abs(current_channel - target_channel)
for i in range(1000001): # 왜 500000 까지 아니고 10000001 까지인지 모르겠음
    for j in str(i):
        if j in broken_buttons:
            break
    else:
        count = min(count, len(str(i)) + abs(i - target_channel))

print(count)