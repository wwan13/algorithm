"""
DATE: 2024.03.20
QUE NUM: 15661
QUE NAME: 링크와 스타트
QUE TYPE: brute force
https://www.acmicpc.net/problem/15661
"""

import sys
from itertools import combinations


input = sys.stdin.readline


def solution():
    n = int(input())
    all_players = []
    data = []
    for i in range(n):
        all_players.append(i)
        data.append(list(map(int, input().split())))

    result = int(1e9)

    for i in range(1, n // 2 + 1):
        for team_a in combinations(all_players, i):
            team_b = tuple([player for player in all_players if player not in team_a])

            score_team_a = 0
            score_team_b = 0

            for pair in combinations(team_a, 2):
                if len(pair) == 1:
                    break
                player_a, player_b = pair
                score_team_a += data[player_a][player_b]
                score_team_a += data[player_b][player_a]

            for pair in combinations(team_b, 2):
                if len(pair) == 1:
                    break
                player_a, player_b = pair
                score_team_b += data[player_a][player_b]
                score_team_b += data[player_b][player_a]

            result = min(result, abs(score_team_a - score_team_b))

    print(result)


solution()
