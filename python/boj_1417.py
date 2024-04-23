import sys
import heapq

input = sys.stdin.readline


def solution(n, win, data):
    target = win
    heap = list()
    for e in data:
        heapq.heappush(heap, (-e, e))

    answer = 0
    while heap:
        vote = heapq.heappop(heap)[1]
        if vote >= target:
            vote -= 1
            target += 1
            answer += 1
            heapq.heappush(heap, (-vote, vote))

    return answer


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    win = int(input())
    data = [int(input()) for _ in range(n-1)]
    answer = solution(n, win, data)
    display_result(answer)


main()