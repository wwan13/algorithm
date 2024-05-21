import sys

input = sys.stdin.readline


def solution():
    highest = 1000000
    dp = [0] * (highest + 1)
    prefix_sum = [0] * (highest + 1)

    for i in range(1, highest + 1):
        j = 1
        while i * j <= highest:
            dp[i*j] += i
            j += 1
        prefix_sum[i] = prefix_sum[i-1] + dp[i]

    t = int(input())
    for _ in range(t):
        a = int(sys.stdin.readline())
        sys.stdout.write(str(prefix_sum[a]) + "\n")


def main():
    solution()


main()