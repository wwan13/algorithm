"""
DATE: 2024.03.07
QUE NUM: 20207
QUE NAME: 달력
QUE TYPE: implementation
https://www.acmicpc.net/problem/20291
"""

import sys
input = sys.stdin.readline


class Schedule:
    def __init__(self, start, end):
        self.start = start
        self.end = end


class Calendar:
    def __init__(self):
        self.value = [0] * 366

    def add_schedule(self, schedule):
        for i in range(schedule.start, schedule.end + 1):
            self.value[i] += 1

    def count_filled_area(self):
        result = 0
        width = 0
        height = 0

        for i in range(1, 366):
            if self.value[i] != 0:
                width += 1
                height = max(height, self.value[i])
                if i == 365:
                    result += width * height
            else:
                result += width * height
                width = 0
                height = 0

        return result


def input_data():
    n = int(input())
    schedules = []

    for i in range(n):
        start, end = map(int, input().split())
        schedules.append(Schedule(start, end))

    return schedules


def display_result(calendar):
    print(calendar.count_filled_area())


def solution():
    schedules = input_data()
    schedules.sort(key=lambda x: (x.start, x.end - x.start))
    calendar = Calendar()

    for schedule in schedules:
        calendar.add_schedule(schedule)
    display_result(calendar)


solution()
