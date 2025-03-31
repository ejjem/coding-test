import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int, input().split())
queue = deque()
visited = set()
queue.append((N, 0))
visited.add(N)

while True:
  n, time = queue.popleft()
  if n == K:
    print(time)
    break
  if n < K:
    if n + 1 not in visited:
      visited.add(n+1)
      queue.append((n + 1, time + 1))
    if n * 2 not in visited:
      visited.add(2*n)
      queue.append((2*n, time + 1))
  if n > 0:
    if n - 1 not in visited:
      visited.add(n-1)
      queue.append((n-1, time + 1))

  
  