import sys

input = sys.stdin.readline


def solution():
    natural_nums = set(range(1, 10001))
    generated_nums = set()
    for i in range(1, 10001):
        words = list(map(int, str(i).rstrip()))
        generated_nums.add(sum(words) + i)

    self_nums = sorted(natural_nums - generated_nums)
    for n in self_nums:
        print(n)


def main():
    solution()


main()