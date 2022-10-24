> 이중배열에서 원하는 값 찾는법

```python
a = [(i, j) for iin range(n) for j in range(m)  if data[i][j]==1] # [(a,b)]

x, y = map(int, [(i, j) for iin range(n) for j in range(m)  if data[i][j]==1][0]) # x = a, y = b
```