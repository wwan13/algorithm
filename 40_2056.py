"""
DATE: 2023.04.07
QUE NUM: 2056
QUE NAME: 작업
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/2056
"""
import sys

imput = sys.stdin.readline

n = int(input())
dp = [0] * n

for i in range(n):
    time, pre_tast_num, *pre_tasks = map(int, input().split())
    dp[i] = time
    
    for task in pre_tasks:
        dp[i] = max(dp[i], dp[task-1] + time)

print(max(dp))