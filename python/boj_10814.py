import sys

input = sys.stdin.readline


def solution(n, data):
    return sorted(data, key=lambda x: (x[0], x[2]))


def display_result(answer):
    for e in answer:
        print(e[0], e[1])


def main():
    n = int(input())
    data = list()
    for i in range(n):
        age, name = map(str, input().split())
        data.append([int(age), name, i])
    answer = solution(n, data)
    display_result(answer)


main()