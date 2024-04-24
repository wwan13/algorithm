import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    heap = list()
    for e in data:
        heapq.heappush(heap, e)

    answer = 0
    for i in range(n-1):
        n1 = heapq.heappop(heap)
        n2 = heapq.heappop(heap)

        answer += n1 + n2
        heapq.heappush(heap, n1 + n2)

    return answer


def display_result(answer):
    print(answer)


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        data = list(map(int, input().split()))
        answer = solution(n, data)
        display_result(answer)


main()
