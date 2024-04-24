import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    heap = list()
    data.sort()
    heapq.heappush(heap, (data[0][1], 0))
    count = [1]

    for i in range(1, n):
        if heap[0][0] > data[i][0]:
            heapq.heappush(heap, (data[i][1], len(count)))
            count.append(1)
            continue
        left = heapq.heappop(heap)
        count[left[1]] += 1
        heapq.heappush(heap, (data[i][1], 0))

    print(len(heap))
    for e in count:
        print(e, end=" ")


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    solution(n, data)


main()