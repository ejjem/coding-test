from collections import deque

T = int(input())
answer = []
for ts in range(1, T+1):
  N = int(input())
  data = [list(map(int, str(input()))) for _ in range(N)]
  price = [[float('inf')] * N for _ in range(N)]
  queue = deque()
  queue.append((0, 0, 0))
  while queue:
    x, y, w = queue.popleft()
    dists = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    for dx, dy in dists:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < N:
        tmp = data[nx][ny] + w
        if tmp < price[nx][ny]:
          price[nx][ny] = tmp
          queue.append((nx, ny, tmp))
  answer.append(f"#{ts} {price[N-1][N-1]}")
print("\n".join(answer))