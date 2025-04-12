import sys
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(5)]
anounce = []
for _ in range(5):
  arr = list(map(int, input().split()))
  anounce.extend(arr)

for i in range(len(anounce)):
  target = anounce[i]
  bingo = 0
  for row in board:
    if target in row:
      row[row.index(target)] = -1
    if all(number == -1 for number in row):
      bingo += 1
  for col in range(5):
    check = [board[i][col] for i in range(5)]
    if all(number == -1 for number in check):
      bingo += 1
  if all(board[x][x] == -1 for x in range(5)):
    bingo += 1
  if all(board[x][4-x] == -1 for x in range(5)):
    bingo += 1
  
  if bingo >= 3:
    print(i+1)
    break