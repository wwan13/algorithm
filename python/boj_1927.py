import sys
import heapq

input = sys.stdin.readline


def solution(n):
    heap = list()

    for i in range(n):
        num = int(input())
        if num == 0:
            if len(heap) == 0:
                print(0)
            else:
                print(heapq.heappop(heap))
            continue

        heapq.heappush(heap, num)


def main():
    n = int(input())
    solution(n)


main()
