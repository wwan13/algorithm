'''
n 의 범위가 1 ≤ N ≤ 1,000,000
m 의 범위가 1 ≤ M ≤ 2,000,000,000
이기 떄문에 완전 탐색 으로는 절대 X
'''

import sys

input = sys.stdin.readline

def solution(n, m, data):
    start = 1
    end = max(data)

    while start <= end:
        middle = (start + end) // 2
        trees = 0

        for e in data:
            if e >= middle:
                trees += e - middle

        if trees >= m:
            start = middle + 1
        else:
            end = middle - 1

    return end


def display_result(answer):
    print(answer)


def main():
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    answer = solution(n, m, data)
    display_result(answer)


main()