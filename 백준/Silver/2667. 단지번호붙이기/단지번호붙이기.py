import sys
input = sys.stdin.readline
N = int(input())
board = [ list(map(int, list(input().rstrip()))) for _ in range(N)]
visited = set()
dist = [(1, 0), (0, 1), (-1, 0), (0, -1)]
answer = []
def DFS(board, visited, dist, answer, starting_x, starting_y):
  stack = [(starting_x, starting_y)]
  tmp = []
  count = 0
  while stack:
    x, y = stack.pop()
    if (x, y) not in visited:
      visited.add((x, y))
      count += 1
    for dx, dy in dist:
      X, Y = dx + x, dy + y
      if 0 <= X <= N-1 and 0<= Y <= N-1:
        if board[Y][X] == 1 and (X, Y) not in visited:
          stack.append((X, Y))
  answer.append(count)
  
for x in range(N):
  for y in range(N):
    if board[y][x] == 1 and (x, y) not in visited:
      DFS(board, visited, dist, answer, x, y)
answer.sort()
print(len(answer))
for num in answer:
  print(num)