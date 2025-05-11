#import sys
#sys.stdin = open('input.txt', 'r')

for tc in range(1, 11):
  N = int(input())
  board = [ list(map(int, input().split())) for _ in range(100)]
  count = 0
  for col in range(100):
    flag_N = float('inf')
    flag_S = -float('inf')
    for row in range(100):
      if board[row][col] == 1:
        flag_N = row
      if board[row][col] == 2:
        flag_S = row
      if flag_N < flag_S:
        count += 1
        flag_N = float('inf')
        flag_S = -float('inf')
  print(f"#{tc} {count}")