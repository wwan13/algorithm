import sys

input = sys.stdin.readline


def solution(n, m, data):
    if max(data) == 0:
        return "SAD"

    prefix_sum = [0]
    for i in range(n):
        prefix_sum.append(prefix_sum[i] + data[i])

    max_value = -1
    count = 0
    for i in range(n - m + 1):
        visited = prefix_sum[i+m] - prefix_sum[i]
        if visited > max_value:
            count = 1
            max_value = visited
        elif visited == max_value:
            count += 1

    return max_value, count


def display_result(answer):
    [print(e) for e in answer]


def main():
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    answer = solution(n, m, data)
    display_result(answer)


main()