import sys
from collections import deque

input = sys.stdin.readline


def solution(n, ternel_in, ternel_out):
    answer = 0
    cars_in_queue = deque(ternel_in)

    for i in range(0, n):
        target = ternel_out[i]

        if target == cars_in_queue[0]:
            cars_in_queue.popleft()
            continue

        cars_in_queue.remove(target)
        answer += 1

    return answer


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    ternel_in = [input().strip() for _ in range(n)]
    ternel_out = [input().strip() for _ in range(n)]
    answer = solution(n, ternel_in, ternel_out)
    display_result(answer)


main()
