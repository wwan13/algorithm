"""
DATE: 2024.03.07
QUE NUM: 20291
QUE NAME: 파일 정리
QUE TYPE: implementation
https://www.acmicpc.net/problem/20291
"""

import sys

input = sys.stdin.readline


class File:
    def __init__(self, name, extension):
        self.name = name
        self.extension = extension


def input_datas():
    delimiter = "."

    n = int(input())
    files = []
    for i in range(n):
        name, extension = map(str, input().split(delimiter))
        files.append(File(name.strip(), extension.strip()))
    return files

def display_result(result):
    for key, value in result:
        print("{} {}".format(key, value))

def solution():
    files = input_datas()
    result = dict()

    for file in files:
        if file.extension not in result.keys():
            result[file.extension] = 0
        result[file.extension] += 1

    sorted_result = sorted(result.items())
    display_result(sorted_result)


solution()
