import sys

input = sys.stdin.readline


def solution(n, s, data):
    left, right = 0, 0
    prefix_sum = 0
    answer = sys.maxsize

    while True:
        if prefix_sum >= s:
            answer = min(answer, right - left)
            prefix_sum -= data[left]
            left += 1
        elif right == n:
            break
        else:
            prefix_sum += data[right]
            right += 1

    if answer == sys.maxsize:
        return 0
    else:
        return answer


def display_result(answer):
    print(answer)


def main():
    n, s = map(int, input().split())
    data = list(map(int, input().split()))
    answer = solution(n, s, data)
    display_result(answer)


main()