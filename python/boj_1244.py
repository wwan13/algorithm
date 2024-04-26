import sys

input = sys.stdin.readline

def switch_swap(switch_status):
    if switch_status == 1:
        return 0
    return 1


def solution(n, switches, m, data):
    switches.insert(0, -1)

    for e in data:
        gender, number = e

        if gender == 1: # 남자
            while number < n + 1:
                switches[number] = switch_swap(switches[number])
                number *= 2

        if gender == 2: # 여자
            for scale in range(n//2):
                if number + scale >= n or number - scale < 1:
                    break
                if switches[number + scale] != switches[number - scale]:
                    break

                switches[number + scale] = switch_swap(switches[number + scale])
                switches[number - scale] = switch_swap(switches[number - scale])

    switches.pop(0)

    return switches


def display_result(answer):
    for i in range(len(answer)):
        print(answer[i], end=" ")
        if i % 20 == 0 and i != 0:
            print()


def main():
    n = int(input())
    switches = list(map(int, input().split()))
    m = int(input())
    data = [list(map(int, input().split())) for _ in range(m)]
    answer = solution(n, switches, m, data)
    display_result(answer)


main()