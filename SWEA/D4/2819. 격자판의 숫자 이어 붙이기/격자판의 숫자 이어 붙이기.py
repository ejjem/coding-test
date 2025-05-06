T = int(input())
for tc in range(1, T+1):
  board = [ list(map(int, input().split())) for _ in range(4)]
  possible = set()
  direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]
  def DFS(start_x, start_y, board, possible, direction):
    tmp = str(board[start_y][start_x])
    stack = [(start_x, start_y, tmp, 0)]
    while stack:
      x, y, string, count = stack.pop()
      if count == 6:
        possible.add(string)
      if count < 6:
        for dx, dy in direction:
          X, Y = x + dx, y + dy
          if 0 <= X <= 3 and 0 <= Y <= 3:
            stack.append((X, Y, string + str(board[Y][X]), count + 1))
  for x in range(4):
    for y in range(4):
      DFS(x, y, board, possible, direction) 
  print(f"#{tc} {len(possible)}")