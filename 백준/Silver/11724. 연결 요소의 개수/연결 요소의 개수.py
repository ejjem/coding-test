import sys
from collections import defaultdict
input = sys.stdin.readline

N, M = map(int, input().split())
graph = defaultdict(list)
for _ in range(M):
  u, v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)
visited = set()
count = 0
def DFS(node):
  global graph
  global count
  stack = [node]
  while stack:
    tmp = stack.pop()
    if tmp not in visited:
      visited.add(tmp)
      for neighbor in graph[tmp]:
        if neighbor not in visited:
          stack.append(neighbor)
  count += 1

for i in range(1, N+1):
  if i not in visited:
    DFS(i)
print(count)