import sys

input = sys.stdin.readline


def solution(k, n):
    people = [i for i in range(1, n+1)]

    for i in range(k):
        for j in range(1, n):
            people[j] += people[j-1]

    return people[-1]


def display_result(answer):
    print(answer)


def main():
    t = int(input())
    for _ in range(t):
        k = int(input())
        n = int(input())
        answer = solution(k, n)
        display_result(answer)


main()