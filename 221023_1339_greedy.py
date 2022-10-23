"""
DATE: 2022.10.23
QUE NUM: 1337
QUE NAME: 단어수학
QUE TYPE: greedy
https://www.acmicpc.net/problem/1337
"""

import sys
input = sys.stdin.readline

#입력
# n = int(input())
# data = [input().strip() for _ in range(n)]

n = 1
data = ['ACDEB']
tmpData = data.copy()

number = 9
dict = {}
while tmpData:
    tmpData = sorted(tmpData, key = lambda x: len(x), reverse = True)
    alpha = tmpData[0][0]
    tmpData[0] = tmpData[0][1:len(tmpData[0])]
    tmpData = list(filter(None, tmpData))

    if alpha not in dict:
        dict[alpha] = number
        number -= 1

result = ["" for _ in range(n)]
for i in range(n):
    for a in data[i]:
        result[i] += str(dict[a])

result = list(map(int, result))
print(sum(result))