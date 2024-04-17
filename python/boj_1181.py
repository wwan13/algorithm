"""
DATE: 2022.10.17
QUE NUM: 1181
QUE NAME: 단어정렬
QUE TYPE: sorting
https://www.acmicpc.net/problem/1181
"""

import sys
imput = sys.stdin.readline

n = int(input())
data = [input() for _ in range(n)]

data = list(set(data))
data.sort(key = lambda x:(len(x),x))
print(*data, sep="\n")