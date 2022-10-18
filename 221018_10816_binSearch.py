"""
DATE: 2022.10.18
QUE NUM: 10816
QUE NAME: 단어정렬
QUE TYPE: binary search
https://www.acmicpc.net/problem/10816
"""

from bisect import bisect_left, bisect_right
import sys
sys.stdin.readline

def count(m):
    rigntIndex = bisect_right(list_n, m)
    leftIndex = bisect_left(list_n, m)

    return rigntIndex - leftIndex

n = int(input())
list_n = list(map(int, input().split()))
m = int(input())
list_m = list(map(int, input().split()))

list_n.sort()
for m in list_m:
    print(count(m), end=" ")
