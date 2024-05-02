import sys

input = sys.stdin.readline


def solution(n):
    queue = []

    for i in range(n):
        cmd = sys.stdin.readline().split()

        if cmd[0] == "push":
            queue.insert(0, cmd[1])

        elif cmd[0] == "pop":
            if len(queue) != 0:
                print(queue.pop())
            else:
                print(-1)

        elif cmd[0] == "size":
            print(len(queue))

        elif cmd[0] == "empty":
            if len(queue) == 0:
                print(1)
            else:
                print(0)

        elif cmd[0] == "front":
            if len(queue) == 0:
                print(-1)
            else:
                print(queue[len(queue) - 1])

        elif cmd[0] == "back":
            if len(queue) == 0:
                print(-1)
            else:
                print(queue[0])


def display_result(answer):
    print(answer)


def main():
    n = int(input())
    solution(n)


main()
