import sys

input = sys.stdin.readline


def solution(n, data):
    sorted_data = sorted(set(data))
    dic = {sorted_data[i]: i for i in range(len(sorted_data))}
    for e in data:
        print(dic[e], end=" ")


def main():
    n = int(input())
    data = list(map(int, input().split()))
    solution(n, data)


main()
