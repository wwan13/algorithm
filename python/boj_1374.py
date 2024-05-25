import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    data.sort(key=lambda x: x[1])
    priority_queue = list()
    heapq.heappush(priority_queue, data[0][2])

    for i in range(1, n):
        if data[i][1] < priority_queue[0]:
            heapq.heappush(priority_queue, data[i][2])
        else:
            heapq.heappop(priority_queue)
            heapq.heappush(priority_queue, data[i][2])

    return len(priority_queue)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()
