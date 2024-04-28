import sys

input = sys.stdin.readline


def main():
    n, m = map(int, input().split())
    data = list(map(int, input().split()))

    prefix_sum = [0]
    for i in range(n):
        prefix_sum.append(prefix_sum[i] + data[i])

    for i in range(m):
        start, end = map(int, input().split())
        print(prefix_sum[end] - prefix_sum[start - 1])


main()