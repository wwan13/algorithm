import sys

input = sys.stdin.readline


def calculate_rev_x(value):
    return int("".join(list(reversed(str(value).rstrip()))))


def solution(data):
    rev_x = calculate_rev_x(data[0])
    rev_y = calculate_rev_x(data[1])

    answer = calculate_rev_x(rev_x + rev_y)
    return answer


def display_result(answer):
    print(answer)


def main():
    data = list(map(int, input().split()))
    answer = solution(data)
    display_result(answer)


main()