import sys
import heapq

input = sys.stdin.readline


def solution():
    n = int(input())
    heap = list()

    for _ in range(n):
        numbers = list(map(int, input().split()))
        for number in numbers:
            if len(heap) < n:
                heapq.heappush(heap, number)
                continue

            if number > heap[0]:
                heapq.heappop(heap)
                heapq.heappush(heap, number)

    print(heap[0])


solution()
