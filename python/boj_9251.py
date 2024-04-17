"""
DATE: 2022.11.15
QUE NUM: 9251
QUE NAME: LCS
QUE TYPE: dynamic programming
https://www.acmicpc.net/problem/9251
"""

import sys

input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()

# str1 = "ACAYKP"
# str2 = "CAPCAK"

dp = [[0] * (len(str2)+1) for _ in range(len(str1)+1)]
# print(*dp, sep="\n")

for i in range(1, len(str1)+1):
    for j in range(1, len(str2)+1):
        if str1[i-1] == str2[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])

print(dp[-1][-1])