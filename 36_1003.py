"""
DATE: 2023.04.02
QUE NUM: 1003
QUE NAME: 피보나치 함수
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/1003
"""
import sys

input = sys.stdin.readline

t = int(input())
list = [int(input()) for _ in range(t)]

for n in list:
    zero = [1,0,1]
    one = [0,1,1]

    if n >= 3:
        for i in range(2, n):
            zero.append(zero[i-1] + zero[i])
            one.append(one[i-1] + one[i])
    
    print(f"{zero[n]} {one[n]}")