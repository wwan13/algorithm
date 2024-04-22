import sys

input = sys.stdin.readline


def solution(n, numbers, m, sections):

    accumulated_sum = list()
    accumulated_sum.append(0)

    for i in range(n):
        accumulated_sum.append(accumulated_sum[i] + numbers[i])

    answer = list()

    for section in sections:
        start = section[0]
        end = section[1]
        answer.append(accumulated_sum[end] - accumulated_sum[start - 1])

    return answer


def display_result(answer):
    for e in answer:
        print(e)


def main():
    n = int(input())
    numbers = list(map(int, input().split()))
    m = int(input())
    sections = [list(map(int, input().split())) for _ in range(m)]
    answer = solution(n, numbers, m, sections)
    display_result(answer)


main()
