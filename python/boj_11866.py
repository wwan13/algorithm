import sys
from collections import deque

input = sys.stdin.readline


def solution(n, k):
    queue = deque([i for i in range(1, n+1)])
    answer = list()

    while len(queue) > 0:
        for _ in range(k-1):
            tmp = queue.popleft()
            queue.append(tmp)
        num = queue.popleft()
        answer.append(str(num))

    return answer


def display_result(answer):
    print("<", end="")
    print(", ".join(answer), end="")
    print(">", end="")


def main():
    n, k = map(int, input().split())
    answer = solution(n, k)
    display_result(answer)


main()