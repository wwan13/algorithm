"""
DATE: 2022.10.10
QUE NUM: 1946
QUE NAME: 신입 사원
QUE TYPE: greedy
https://www.acmicpc.net/problem/1946
"""

from operator import index

testCases = int(input())
for _ in range(testCases):
    applicants = int(input())
    entireScore = []
    for _ in range(applicants):
        entireScore.append(list(map(int, input().split())))

    # subTop = []
    # for i in range(2):
        # subTop.append(min(entireScore, key=lambda x:x[i]))
    sub1Top = min(entireScore, key=lambda x:x[0])
    sub2Top = min(entireScore, key=lambda x:x[1])

    entireScore.sort(key=lambda x:x[0])
    indexNum = entireScore.index(sub2Top)
    result = 2
    for i in range(1,indexNum):
        if entireScore[i][1] < sub1Top[1]:
            result += 1
    # entireScore = entireScore[0:indexNum]
    # entireScore.sort(key=lambda x:x[1])
    # indexNum = entireScore.index(subTop[0])
    # entireScore = entireScore[0:indexNum]

    print(result)

    # tmpScore = entireScore[:]
    # topApplicants = []
    # for i in range(2):
    #     subjectTop = min(entireScore, key=lambda x:x[i])
    #     topApplicants.append(subjectTop)
    #     tmpScore.remove(subjectTop)

    # delList = []
    # for i in range(2):
    #     if i == 0:
    #         subject = 1
    #     else:
    #         subject = 0

    #     for j in range(len(tmpScore)):
    #         if tmpScore[j][subject] > topApplicants[i][subject]:
    #             delList.append(tmpScore[j])
    #     for j in delList:
    #         tmpScore.remove(j)

    #     delList.clear()

    # result = len(tmpScore) + 2
    # print(result)