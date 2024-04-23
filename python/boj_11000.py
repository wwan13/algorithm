import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    data.sort()
    heap = list()
    heapq.heappush(heap, data[0][1])

    for i in range(1, n):
        if data[i][0] < heap[0]:
            heapq.heappush(heap, data[i][1])
            continue
        heapq.heappop(heap)
        heapq.heappush(heap, data[i][1])

    return len(heap)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()