import sys
from collections import deque
input = sys.stdin.readline

M, N = map(int, input().split())
tomato = []
riped_tomato = []
not_tomato = 0
for i in range(N):
  tmp = list(map(int, input().split()))
  tomato.append(tmp)
  if -1 in tmp:
    not_tomato += tmp.count(-1)  
  if 1 in tmp:
    for j in range(M):
      if tmp[j] == 1:
        riped_tomato.append((j, i))

queue = deque()
visited = set()
dists = [(1, 0), (0, 1), (-1, 0), (0, -1)]
w_max = 0
for x, y in riped_tomato:
  queue.append((x, y, 0))
  visited.add((x, y))

while queue:
  x, y, w = queue.popleft()
  w_max = max(w_max, w)
  for dx, dy in dists:
    nx, ny = x + dx, y + dy
    if 0 <= nx <= M-1 and 0 <= ny <= N-1:
      if tomato[ny][nx] != -1 and (nx, ny) not in visited:
        queue.append((nx, ny, w+1))
        visited.add((nx, ny))

if len(visited) + not_tomato == M * N :
  print(w_max)
else:
  print(-1)