> dfs
```python
def dfs(graph, v, visited):
    # 방문처리
    visited[v] = True
    print(v, end=' ')

    # 그래프를 조건에 맞게 정렬
    graph[v].sort()

    # 그래프가 끝날때까지
    for i in graph[v]:
        # 발문하지 않은 노드에 대해 재귀 호출
        if not visited[i]:
            dfs(graph, i, visited)
```

> bfs
```python
# queue 사용을 위해 deque 라이브러리 임포트
from collaboration import deque

def bfs(graph, v, visited):
    # 큐 생성
    queue = deque([v])
    # 방문처리
    visited[v] = True

    # 큐가 빌때까지
    while queue:
        # 큐에서 하나씩 뽑음
        v = queue.popleft()
        print(v, end=' ')
        
        # 그래프를 조건에 대해 정렬
        graph[v].sort()

        # 그래프가 끝날떄까지
        for i in graph[v]:
            # 방문하지 않은 노드이면 큐에 삽입 후 방문처리
            if not visited[i]:
                queue.append(i)
                visited[i] = True
```