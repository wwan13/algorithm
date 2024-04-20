import math
import sys

input = sys.stdin.readline


def solution(data):
    if math.sqrt(data) == int(math.sqrt(data)):
        return 1

    for i in range(1, int(math.sqrt(data)) + 1):
        if math.sqrt(data - i**2)  == int(math.sqrt(data - i**2)):
            return 2

    for i in range(1, int(math.sqrt(data)) + 1):
        for j in range(1, int(math.sqrt(data - i**2)) + 1):
            if math.sqrt(data - i**2 - j**2) == int(math.sqrt(data - i**2 - j**2)):
                return 3

    return 4


def display_result(answer):
    print(answer)


def main():
    data = int(input())
    answer = solution(data)
    display_result(answer)


main()