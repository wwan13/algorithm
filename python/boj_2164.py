import sys
from collections import deque

input = sys.stdin.readline


def solution(n):
    queue = deque()
    [queue.append(i) for i in range(1, n+1)]

    while len(queue) > 1:
        # 제일 위에 있는 카드를 바닥에 버린다
        queue.popleft()

        # 그 다음 제일 위에 있는 카드를
        num = queue.popleft()

        # 제일 아래에 있는 카드 밑으로 옮긴다
        queue.append(num)

    return queue.popleft()


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    answer = solution(n)
    display_result(answer)


main()