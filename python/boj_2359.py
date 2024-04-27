import sys

input = sys.stdin.readline


def solution(n, k, data):
    part_sum = sum(data[:k])
    print(part_sum)
    result_list = [part_sum]

    for i in range(0, len(data) - k):
        part_sum = part_sum - data[i] + data[i + k]
        result_list.append(part_sum)

    return max(result_list)


def display_result(answer):
    print(answer)


def main():
    n, k = map(int, input().split())
    data = list(map(int, input().split()))
    answer = solution(n, k, data)
    display_result(answer)


main()