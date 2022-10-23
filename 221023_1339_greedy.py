"""
DATE: 2022.10.23
QUE NUM: 1337
QUE NAME: 단어수학
QUE TYPE: greedy
https://www.acmicpc.net/problem/1337
"""

import sys
input = sys.stdin.readline

N = int(input())
words = [input().rstrip() for _ in range(N)]

dict = {}

for w in words:
    cnt = len(w)-1
    for ww in w:
        if ww not in dict:
            dict[ww] = pow(10, cnt)
        else:
            dict[ww] += pow(10, cnt)
        cnt -= 1

dict = sorted(dict.values(), reverse=True)

result = 0
num = 9

for v in dict:
    result += v*num
    num -= 1

print(result)