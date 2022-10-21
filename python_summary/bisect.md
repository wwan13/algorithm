> bisect 라이브러리에 대해

```python
from bisect import bisect_left, bisect_right

# 정렬 필수
data = [0, 1, 2, 2, 3, 4]

# 첫번째 매개변수(리스트) 에 대해 두번째 매개변수(2)
# 가 들어갈 수 있는 가장 '왼쪽' 인덱스 번호를 반환
n = bisect_left(data, 2) # n = 2

# 첫번째 매개변수(리스트) 에 대해 두번째 매개변수(2)
# 가 들어갈 수 있는 가장 '오른쪽' 인덱스 번호를 반환
n = bisect_right(data, 2)# n = 4
```

<br/>
위 라이브러리를 이용해 정렬이 되어있는 리스트에 대해 <br/>
내가 찾으려고 하는 원소의 갯수 찾기 가능
``` python
def get_number_of_element(data, n):
    right = bisect_right(data, 2)
    left = bisect_left(data, 2)

    return right - left

data = [0, 1, 2, 2, 3, 4]
get_number_of_element(data, 2) # result = 2
```
