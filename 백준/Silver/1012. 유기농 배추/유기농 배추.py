import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
  M, N, K = map(int, input().split())
  board = [ [0] * M for _ in range(N)]
  for _ in range(K):
    x, y = map(int, input().split())
    board[y][x] = 1
  visited = set()
  answer = 0
  def DFS(start_x, start_y):
    global visited, answer, board
    stack = [(start_x, start_y)]
    direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    while stack:
      x, y = stack.pop()
      if board[y][x] == 1 and (x, y) not in visited:
        visited.add((x, y))
        for dx, dy in direction:
          X, Y = dx + x, dy + y
          if 0 <= X <= M-1 and 0<= Y <= N-1:
            if board[Y][X] == 1 and (X, Y) not in visited:
              stack.append((X, Y))
  for y in range(N):
    for x in range(M):
      if board[y][x] == 1 and (x, y) not in visited:
        DFS(x, y)
        answer += 1
  print(answer)