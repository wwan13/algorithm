import sys

input = sys.stdin.readline


def solution(n, m, b, data):
    min_time = 1e9
    height = 0

    for k in range(min(map(min, data)), max(map(max, data)) + 1):
        floor = k

        blocks_remain = b
        time = 0
        for i in range(n):
            for j in range(m):
                target = data[i][j]
                if target > floor:
                    time += (target - floor) * 2
                    blocks_remain += target - floor
                else:
                    time += (floor - target) * 1
                    blocks_remain -= floor - target

        if blocks_remain >= 0 and time <= min_time:
            height = floor
            min_time = time

    return (min_time, height)


def display_result(answer):
    print("{} {}".format(answer[0], answer[1]))


def main():
    n, m, b = map(int, input().split())
    data = [list(map(int, input().split())) for _ in range(n)]
    answer = solution(n, m, b, data)
    display_result(answer)


main()
