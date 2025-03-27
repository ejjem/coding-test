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
answer = []

def DFS(node):
  global graph
  global nodes
  global visited
  global answer
  stack = [node]
  result = []

  while stack:
    tmp = stack.pop()
    if tmp not in visited:
      visited.add(tmp)
      result.append(tmp)
      
      for neighbor in graph[tmp]:
        if neighbor not in visited:
          stack.append(neighbor)

  answer.append(result)

for node in range(1, N+1):
  if node not in visited:
    DFS(node)
    
print(len(answer))
  