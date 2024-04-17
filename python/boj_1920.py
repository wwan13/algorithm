"""
DATE: 2022.10.17
QUE NUM: 1920
QUE NAME: 단어정렬
QUE TYPE: binary search
https://www.acmicpc.net/problem/1920
"""

import sys
input = sys.stdin.readline

def binarySearch(list_n, m, start, end):
    while start <= end:
        mid = (start + end) // 2

        if m < list_n[mid]:
            end = mid - 1
        elif m > list_n[mid]:
            start = mid + 1
        elif m == list_n[mid]:
            return 1

    return 0

n = int(input())
list_n = list(map(int, input().split()))
m = int(input())
list_m = list(map(int, input().split()))

# n = 5
# list_n = [4, 1, 5, 2, 3]
# m = 5
# list_m = [1, 3, 7, 9, 5]

list_n.sort()

for m in list_m:
    print(binarySearch(list_n, m, 0, n-1))
