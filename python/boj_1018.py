import sys

input = sys.stdin.readline


def solution(n, m, data):
    answer = 1e9

    for a in range(n - 7):
        for b in range(m - 7):
            index1 = 0
            index2 = 0

            for i in range(a, a + 8):
                for j in range(b, b + 8):
                    if (i + j) % 2 == 0:
                        if data[i][j] != 'W':
                            index1 += 1
                        if data[i][j] != 'B':
                            index2 += 1
                    else:
                        if data[i][j] != 'B':
                            index1 += 1
                        if data[i][j] != 'W':
                            index2 += 1

            answer = min(answer, index1, index2)

    return answer


def display_result(answer):
    print(answer)


def main():
    n, m = map(int, input().split())
    data = [list(map(str, input().rstrip())) for _ in range(n)]
    answer = solution(n, m, data)
    display_result(answer)


main()
