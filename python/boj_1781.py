import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    data.sort()
    queue = []

    for e in data:
        heapq.heappush(queue, e[1])
        if e[0] < len(queue):
            heapq.heappop(queue)

    return sum(queue)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()