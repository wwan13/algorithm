"""
DATE: 2022.10.27
QUE NUM: 14501
QUE NAME: 퇴사
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/14501
"""

import sys
input = sys.stdin.readline

n = int(input())
t_list = []
p_list = []
for _ in range(n):
    t, p = map(int, input().split())
    t_list.append(t)
    p_list.append(p)

cache = [0] * (n+1)

for i in range(n-1,-1,-1):
    if t_list[i] + i > n:
        cache[i] = cache[i+1]
    else:
        # (지금 일 보상 + 쌓여있는 보상), (일을 하지 않았을때) 비교
        cache[i] = max(p_list[i] + cache[i + t_list[i]], cache[i+1])

print(cache[0])

