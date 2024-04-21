import sys

input = sys.stdin.readline


def solution(n, data):
    answer = -1

    for i in range(n):
        friends = set()
        for j in range(n):
            if i == j or data[i][j] == 'N':
                continue

            friends.add(j)

            for k in range(n):
                if k == i:
                    continue

                if data[j][k] == 'Y':
                    friends.add(k)

        answer = max(answer,len(friends))

    return answer


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    data =[list(map(str, input().rstrip())) for _ in range(n)]
    answer = solution(n, data)
    display_result(answer)


main()