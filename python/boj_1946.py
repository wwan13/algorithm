"""
DATE: 2022.10.10
QUE NUM: 1946
QUE NAME: 신입 사원
QUE TYPE: greedy
https://www.acmicpc.net/problem/1946
"""
import sys
input = sys.stdin.readline

testCases = int(input())
for _ in range(testCases):
    applicants = int(input())
    scores = [list(map(int, input().split())) for _ in range(applicants)]
    scores_asc = sorted(scores)

    top = 0
    result = 1
    for i in range(1, applicants):
        if scores_asc[i][1] < scores_asc[top][1]:
            top = i
            result += 1

    print(result)
    

    