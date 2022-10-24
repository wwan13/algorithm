"""
DATE: 2022.10.23
QUE NUM: 2110
QUE NAME: 공유기설치
QUE TYPE: binary search
https://www.acmicpc.net/problem/2110
"""

import sys
input = sys.stdin.readline

n, c = map(int, input().split())
houses = [int(input()) for _ in range(n)]
houses.sort()

# 집 사이의 거리로 시작, 끝을 정함
start = 1
end = houses[-1] - houses[0]
result = 0

# 공유기가 2개밖에 없으면 무조건 처음과 끝집
if c == 2:
    result = houses[-1] - houses[0]
else:
    while start < end:
        mid = ( start + end ) // 2
        count = 1
        current_installed = houses[0] # 가장 최근 설치된 공유기의 집 좌표 ( 시작은 무조건 첫집 )
        
        # 모든 집들에 대해
        for h in houses:
            # 가장 최근 설치된 집과의 거리가 mid 보다 클 경우에만
            if h - current_installed >= mid:
                count += 1
                current_installed = h # 최근 설치된 집을 현제 집으로 바꿈

        # * 최댓값을 찾은 것이므로 if count == c: 를 따로 하면 안됨 *
        if count >= c:
            result = mid
            start = mid + 1
        else:
            end = mid

print(result)


