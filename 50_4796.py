"""
DATE: 2023.10.05
QUE NUM: 4796
QUE NAME: 캠핑
https://www.acmicpc.net/problem/4796
"""

import sys
input = sys.stdin.readline

case = 0
while True:
    case += 1
    l, p, v = map(int, input().split())
    if l == 0 and p == 0 and v == 0:
        break
    
    result = (v // p) * l
    result += min((v % p), l)

    print("Case %d: %d" %(case, result))
    