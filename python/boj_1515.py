import sys

input = sys.stdin.readline


def solution(data):
    n = 0
    idx = 0
    while True:
        n += 1
        for s in str(n):
            if data[idx] == s:
                idx += 1
                if idx >= len(data):
                    return n


def display_result(answer):
    print(answer)


def main():
    data = input().rstrip()
    answer = solution(data)
    display_result(answer)


main()
