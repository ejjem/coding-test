import sys
from collections import defaultdict
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())
graph = defaultdict(list)
for _ in range(M):
  u, v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

for key in graph:
  graph[key].sort()


def DFS(node):
  global graph
  stack = [node]
  visited = set()
  result = []
  while len(stack) != 0:
    tmp = stack.pop()
    if tmp not in visited:
      visited.add(tmp)
      result.append(tmp)
    if len(graph[tmp]) != 0:
      for i in reversed(graph[tmp]):
        if i not in visited:
          stack.append(i)
  print(" ".join(map(str, result)))

def BFS(node):
  global graph
  queue = deque([node])
  visited = set()
  result = []
  while len(queue) != 0:
    tmp = queue.popleft()
    if tmp not in visited:
      visited.add(tmp)
      result.append(tmp)
    if len(graph[tmp]) != 0:
      for i in graph[tmp]:
        if i not in visited:
          queue.append(i)
          
  print(" ".join(map(str, result)))
  
DFS(V)
BFS(V)
