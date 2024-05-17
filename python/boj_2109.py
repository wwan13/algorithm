import sys
import heapq

input = sys.stdin.readline


def solution(n, data):
    data.sort(key=lambda x: x[1])

    queue = list()
    for e in data:
        reward, date = e
        heapq.heappush(queue, reward)

        if len(queue) > date:
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