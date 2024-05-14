import sys

input = sys.stdin.readline


def solution(n, data):
    colors = {"R": 0, "B": 0}
    colors[data[0]] += 1

    for i in range(1, n):
        if data[i] != data[i-1]:
            colors[data[i]] += 1

    return min(colors["R"], colors["B"]) + 1


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = list(map(str, input().rstrip()))
    answer = solution(n, data)
    display_result(answer)


main()
