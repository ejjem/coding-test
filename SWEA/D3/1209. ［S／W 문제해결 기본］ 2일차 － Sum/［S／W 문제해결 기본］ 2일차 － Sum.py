for tc in range(10):
  T = int(input())
  board = [ list(map(int, input().split())) for _ in range(100)]
  maximum = -float('inf')
  # 가로
  for row in board:
    maximum = max(sum(row), maximum)
  # 세로
  for col in range(100):
    tmp = 0
    for row in range(100):
      tmp += board[row][col]
    maximum = max(tmp, maximum)
  # 대각선
  tmp_1, tmp_2 = 0, 0
  for i in range(100):
    tmp_1 += board[i][i]
    tmp_2 += board[i][99-i]
  maximum = max(maximum, tmp_1, tmp_2)
  print(f"#{T} {maximum}")