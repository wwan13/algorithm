import sys
import heapq

input = sys.stdin.readline


def solution(n, m, data):
    heap = list()
    for e in data:
        heapq.heappush(heap, e)

    for _ in range(m):
        n1 = heapq.heappop(heap)
        n2 = heapq.heappop(heap)

        for _ in range(2):
            heapq.heappush(heap, n1 + n2)

    return sum(heap)


def display_result(answer):
    print(answer)


def main():
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    answer = solution(n, m, data)
    display_result(answer)


main()
