import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
miro =  [list(map(int, list(input().rstrip()))) for _ in range(N)]
queue = deque()
queue.append((0, 0, 1))
visited = set()
visited.add((0, 0))
dists = [(1, 0), (0, 1), (-1, 0), (0, -1)]
while queue:
  x, y, w = queue.popleft()
  if x == M -1 and y == N -1:
    print(w)
    break
  for dx, dy in dists:
    nx, ny = x + dx, y + dy
    if 0 <= nx <= M -1 and 0 <= ny <= N - 1 and miro[ny][nx] == 1:
      if (nx, ny) not in visited:
        queue.append((nx, ny, w + 1))
        visited.add((nx, ny))