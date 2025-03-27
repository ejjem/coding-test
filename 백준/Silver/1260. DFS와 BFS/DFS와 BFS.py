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


def DFS(node):
  global graph
  stack = [node]
  result = []
  while len(stack) != 0:
    tmp = stack.pop()
    if tmp not in result:
      result.append(tmp)
    if len(graph[tmp]) != 0:
      arr = graph[tmp]
      arr.sort(reverse=True)
      for i in range(len(arr)):
        if arr[i] not in result:
          stack.append(arr[i])
  print(" ".join(map(str, result)))

def BFS(node):
  global graph
  queue = deque([node])
  result = []
  while len(queue) != 0:
    tmp = queue.popleft()
    if tmp not in result:
      result.append(tmp)
    if len(graph[tmp]) != 0:
      arr = graph[tmp]
      arr.sort()
      for i in range(len(arr)):
        if arr[i] not in result:
          queue.append(arr[i])
  print(" ".join(map(str, result)))
  
DFS(V)
BFS(V)
