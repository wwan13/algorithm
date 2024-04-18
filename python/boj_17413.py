import sys

input = sys.stdin.readline


def reverse_and_to_string(word):
    return str.join("", list(reversed(word)))


def solution(data):
    TAG_OPEN = "<"
    TAG_CLOSE = ">"

    reveresd_words = list()

    if TAG_OPEN not in data and TAG_CLOSE not in data:
        for word in data.split():
            reveresd_words.append(reverse_and_to_string(word))
        return str.join(" ", reveresd_words)

    data_elements = data.rstrip()

    is_tag_opened = False
    tag = list()
    word_tmp = list()
    for e in data_elements:
        if is_tag_opened:
            if e == TAG_CLOSE:
                is_tag_opened = False
                tag.append(e)
                reveresd_words.append(str.join("", tag))
                tag = list()
                continue
            tag.append(e)
            continue

        if e == TAG_OPEN:
            if len(word_tmp) != 0:
                for word in str.join("", word_tmp).split():
                    reveresd_words.append(reverse_and_to_string(word))
                word_tmp = list()
            is_tag_opened = True
            tag.append(e)
            continue

        word_tmp.append(e)

    for word in str.join("", word_tmp).split():
        reveresd_words.append(reverse_and_to_string(word))

    answer = ""
    for i in range(len(reveresd_words) - 1):
        word = reveresd_words[i]
        answer += word
        if word[len(word)-1] != TAG_CLOSE and reveresd_words[i+1][0] != TAG_OPEN:
            answer += " "

    answer += reveresd_words[len(reveresd_words) - 1]
    return answer


def display_result(answer):
    print(answer)


def main():
    data = input()
    answer = solution(data)
    display_result(answer)


main()