"""
DATE: 2022.10.08
QUE NUM: 1026
QUE NAME: 보물
QUE TYPE: greedy
https://www.acmicpc.net/problem/1026
"""

n = int(input())
data1 = list(map(int,input().split()))
data2 = list(map(int,input().split()))

data1.sort()
data2.sort(reverse=True)

result = 0
for i in range(n):
    result += data1[i] * data2[i]

print(result)