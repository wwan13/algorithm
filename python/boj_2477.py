import sys
from collections import deque

input = sys.stdin.readline


def solution(k, data):

    max_x = -1
    max_y = -1
    max_x_index = -1
    max_y_index = -1
    for i in range(6):
        direction, length = data[i]

        if direction == 1 or direction == 2:
            if length > max_x:
                max_x = length
                max_x_index = i
        if direction == 3 or direction == 4:
            if length > max_y:
                max_y = length
                max_y_index = i

    min_x = abs(data[max_x_index - 1][1] - data[(max_x_index - 5 if max_x_index == 5 else max_x_index + 1)][1])
    min_y = abs(data[max_y_index - 1][1] - data[(max_y_index - 5 if max_y_index == 5 else max_y_index + 1)][1])

    total_range = max_x * max_y - min_x * min_y
    return total_range * k


def display_result(answer):
    print(answer)


def main():
    k = int(input())
    data = list()
    for _ in range(6):
        data.append(list(map(int, input().split())))

    answer = solution(k, data)
    display_result(answer)


main()
