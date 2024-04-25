import heapq
import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    heap_queue = list()
    day_max = -1
    for e in data:
        heapq.heappush(heap_queue, (-e[1], e[0]))
        day_max = max(day_max, e[0])

    answer = 0
    days = [False] * (day_max + 1)

    while heap_queue:
        score, day = heapq.heappop(heap_queue)
        score *= -1

        for i in range(day, 0, -1):
            if days[i]:
                continue

            days[i] = True
            answer += score
            break

    return answer


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()