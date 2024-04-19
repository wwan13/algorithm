import sys

input = sys.stdin.readline


def solution(position_king, position_rock, n, data):
    commands = {
        "R": (1, 0),
        "L": (-1, 0),
        "B": (0, -1),
        "T": (0, 1),
        "RT": (1, 1),
        "LT": (-1, 1),
        "RB": (1, -1),
        "LB": (-1, -1),
    }

    line_alpha = ["@", "A", "B", "C", "D", "E", "F", "G", "H"]

    king_x = line_alpha.index(position_king.rstrip()[0])
    king_y = int(position_king.rstrip()[1])
    rock_x = line_alpha.index(position_rock.rstrip()[0])
    rock_y = int(position_rock.rstrip()[1])

    for e in data:
        move_x, move_y = commands[e.strip()]

        if 1 <= king_x + move_x <= 8 and 1 <= king_y + move_y <= 8:
            king_x += move_x
            king_y += move_y

            if king_x == rock_x and king_y == rock_y:
                if 1 <= rock_x + move_x <= 8 and 1 <= rock_y + move_y <= 8:
                    rock_x += move_x
                    rock_y += move_y
                else:
                    king_x -= move_x
                    king_y -= move_y

    return (line_alpha[king_x] + str(king_y), line_alpha[rock_x] + str(rock_y))


def display_result(answer):
    print(answer[0])
    print(answer[1])


def main():
    position_king, position_rock, n = map(str, input().split())
    data = [input() for _ in range(int(n))]
    answer = solution(position_king, position_rock, int(n), data)
    display_result(answer)


main()
