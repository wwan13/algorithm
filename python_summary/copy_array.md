> 배열 복사 하는법

```pyhton
#1 
list2 = list1.copy()

#2
list2 = list1[:]
```

<br/>

> **이중배열 복사하는법**

```python
from copy import deepcopy

list2 = deepcopy(list1)
```