"""
DATE: 2024.03.10
QUE NUM: 15787
QUE NAME: 기차가 어둠을 헤치고 은하수를
QUE TYPE: implementation
https://www.acmicpc.net/problem/15787
"""

import sys

input = sys.stdin.readline


class Trains:
    def __init__(self, n):
        self.value = [[0] * 21]
        for i in range(n):
            self.value.append([0] * 21)

    def get_on_passenger(self, i, x):
        self.value[i][x] = 1

    def get_off_passenger(self, i, x):
        self.value[i][x] = 0

    def move_passengers_back(self, i):
        self.value[i].insert(0, 0)
        self.value[i].pop()

    def move_passengers_forward(self, i):
        self.value[i].append(0)
        self.value[i].pop(0)
        self.value[i][0] = 0

    def count_passable_trains(self):
        tuple_trains = list()
        for train in self.value:
            tuple_trains.append(tuple(train))
        tuple_trains.pop(0)

        trains_after_remove_duplicated = list(set(tuple_trains))
        return len(trains_after_remove_duplicated)


class Command:
    def __init__(self, command, i, x):
        self.command = command
        self.i = i
        self.x = x

    def execute(self, trains):
        if self.command == 1:
            trains.get_on_passenger(self.i, self.x)
        elif self.command == 2:
            trains.get_off_passenger(self.i, self.x)
        elif self.command == 3:
            trains.move_passengers_back(self.i)
        elif self.command == 4:
            trains.move_passengers_forward(self.i)


def input_data():
    n, m = map(int, input().split())
    datas = list()

    for i in range(m):
        element = list(map(int, input().split()))
        if len(element) == 3:
            datas.append(Command(element[0], element[1], element[2]))
        elif len(element) == 2:
            datas.append(Command(element[0], element[1], None))

    return n, datas


def display_result(result):
    print(result)


def solution():
    n, commands = input_data()
    trains = Trains(n)

    for command in commands:
        command.execute(trains)

    display_result(trains.count_passable_trains())


solution()
