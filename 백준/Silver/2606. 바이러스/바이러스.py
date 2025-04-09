import sys
from collections import defaultdict
input = sys.stdin.readline
N = int(input())
M = int(input())
graph = defaultdict(list)
for _ in range(M):
  u, v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

stack = [1]
visited = set()
visited.add(1)
count = 0

while stack:
  tmp = stack.pop()
  for neighbors in graph[tmp]:
    if neighbors not in visited:
      stack.append(neighbors)
      visited.add(neighbors)
      count += 1

print(count)