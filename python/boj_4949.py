import sys
from collections import deque

input = sys.stdin.readline


def solution(data):
    stack = deque()
    for e in data:
        if e == "(":
            stack.append("(")
        if e == ")":
            if len(stack) == 0:
                return "no"
            top = stack.pop()
            if top != "(":
                return "no"

        if e == "[":
            stack.append("[")
        if e == "]":
            if len(stack) == 0:
                return "no"
            top = stack.pop()
            if top != "[":
                return "no"

    if len(stack) > 0:
        return "no"

    return "yes"


def display_result(answer):
    print(answer)


def main():
    while True:
        data = list(map(str, input().rstrip()))
        if len(data) == 1 and data[0] == '.':
            break
        answer = solution(data)
        display_result(answer)


main()