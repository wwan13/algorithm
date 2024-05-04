import sys
from collections import deque

input = sys.stdin.readline


def solution(n, data):
    answer = list()

    for i in range(n):
        target = data[i]
        stack = deque()
        flag = 1

        for e in target:
            if e == "(":
                stack.append("(")
            if e == ")":
                if len(stack) == 0:
                    flag = 0
                    break
                stack.pop()

        if flag == 0 or len(stack) > 0:
            answer.append("NO")
        else:
            answer.append("YES")

    return answer


def display_result(answer):
    for e in answer:
        print(e)


def main():
    n = int(input())
    data = [list(map(str, input().rstrip())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()