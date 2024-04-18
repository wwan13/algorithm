import sys

input = sys.stdin.readline


def solution(n, data):

    total_range = 0

    for i in range(n-1):
        total_range += calculate_distance(data[i][0], data[i][1], data[i+1][0], data[i+1][1])

    min_range = 1e9
    for i in range(1, n-1):
        via_range = (calculate_distance(data[i-1][0], data[i-1][1], data[i][0], data[i][1]) +
                     calculate_distance(data[i][0], data[i][1], data[i+1][0], data[i+1][1]))
        direct_range = calculate_distance(data[i-1][0], data[i-1][1], data[i+1][0], data[i+1][1])

        min_range = min(min_range, total_range - via_range + direct_range)

    return min_range


def calculate_distance(x1, y1, x2, y2):
    return abs(x1 - x2) + abs(y1 - y2)


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = list()
    for i in range(n):
        data.append(list(map(int, input().split())))

    answer = solution(n, data)
    display_result(answer)


main()