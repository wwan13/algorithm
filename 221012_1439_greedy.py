"""
DATE: 2022.10.12
QUE NUM: 1439
QUE NAME: 뒤집기
QUE TYPE: greedy
https://www.acmicpc.net/problem/1439
"""

import sys
input = sys.stdin.readline

s = input().strip()

tmp = s[0]
result = 0
for i in range(1, len(s)):
    if tmp != s[i] and s[i] != s[i - 1]:
        result += 1

print(result)