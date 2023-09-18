elements = [1,1,2,2,2,8]
datas = []
datas = map(int, input().split())
result = []

for element, data in zip(elements, datas):
    result.append(element - data)

for r in result:
    print(r, end=" ")