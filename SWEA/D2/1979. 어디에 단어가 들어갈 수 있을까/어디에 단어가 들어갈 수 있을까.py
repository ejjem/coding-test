T = int(input())
for ts in range(1, T + 1):
  answer = 0
  N, K = map(int, input().split())
  board = [list(map(int, input().split())) for _ in range(N)]
  visited_1 = set()
  visited_2 = set()
  for row in range(N):
    for col in range(N):
      if board[row][col] == 1:
        if (row, col) not in visited_1:
          visited_1.add((row, col))
          tmp = [(row, col)]
          a, b = row, col
          b += 1
          while b < N:
            if board[a][b] == 1 and (a, b) not in visited_1:
              tmp.append((a, b))
              visited_1.add((a, b))
              b += 1
            else:
              break
          if len(tmp) == K:
            left = col - 1
            right = col + K
            if (left < 0 or board[row][left] == 0) and (right >= N or board[row][right] == 0):
              answer += 1
        if (row, col) not in visited_2:
          visited_2.add((row, col))
          tmp2 = [(row, col)]
          c, d = row, col
          c += 1
          while c < N:
            if board[c][d] == 1 and (c, d) not in visited_2:
              tmp2.append((c, d))
              visited_2.add((c, d))
              c += 1
            else:
              break
          if len(tmp2) == K:
            top = row - 1
            bottom = row + K
            if (top < 0 or board[top][col] == 0) and (bottom >= N or board[bottom][col] == 0):
              answer += 1
  print(f"#{ts} {answer}")