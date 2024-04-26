import sys

input = sys.stdin.readline

def solution():
    t = int(input())
    dp = [1, 2, 4]
    for _ in range(t):
        n = int(input())
        for i in range(len(dp), n):
            dp.append((dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009)
        print(dp[n-1])


solution()
