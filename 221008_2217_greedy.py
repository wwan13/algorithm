"""
DATE: 2022.10.08
QUE NUM: 2217
QUE NAME: 로프
QUE TYPE: greedy
https://www.acmicpc.net/problem/2217
"""

n = int(input())

inputData = list()
for i in range(n):
    inputData.append(int(input()))

inputData.sort()
resultData = list()
for i in range(n):
    resultData.append(inputData[i] * (n-i))

result = max(resultData)

print(result)