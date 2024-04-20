import sys

input = sys.stdin.readline


def solution(n, data):
    max_count = -1
    for i in range(n):
        count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
        for j in range(n):
            count[data[i][j]] += 1
        max_count = max(max_count, max(count.values()))

    for j in range(n):
        count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
        for i in range(n):
            count[data[i][j]] += 1
        max_count = max(max_count, max(count.values()))

    if max_count == n:
        return n

    for i in range(n-1):
        for j in range(n):
            candies = [e[:] for e in data]

            if candies[i][j] != candies[i+1][j]:
                candies[i][j], candies[i+1][j] = candies[i+1][j], candies[i][j]

                count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
                for k in range(n):
                    count[candies[i][k]] += 1
                max_count = max(max_count, max(count.values()))

                count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
                for k in range(n):
                    count[candies[i+1][k]] += 1
                max_count = max(max_count, max(count.values()))

    for j in range(n-1):
        for i in range(n):
            candies = [e[:] for e in data]

            if candies[i][j] != candies[i][j+1]:
                candies[i][j], candies[i][j+1] = candies[i][j+1], candies[i][j]

                count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
                for k in range(n):
                    count[candies[k][j]] += 1
                max_count = max(max_count, max(count.values()))

                count = {"C": 0, "P": 0, "Z": 0, "Y": 0}
                for k in range(n):
                    count[candies[k][j+1]] += 1
                max_count = max(max_count, max(count.values()))

    return max_count


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data = [list(map(str, input().rstrip())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()
