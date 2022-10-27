"""
DATE: 2022.10.27
QUE NUM: 9095
QUE NAME: 1,2,3 만들기
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/9095
"""

import sys
input = sys.stdin.readline

def sol(n):
    if n ==1:
        return 1
    elif n==2:
        return 2
    elif n==3:
        return 4
    
    if cache[n] != 0:
        return cache[n]
    else:
        cache[n] = sol(n-3) + sol(n-2) + sol(n-1)
        return cache[n]

n = int(input())
data = [int(input()) for _ in range(n)]

for d in data:
    cache = [0] * (d+1) 
    print(sol(d))




    



