#import sys
#sys.stdin = open('input.txt', 'r')

for tc in range(1, 11):
  N = int(input())
  board = [ list(map(int, input().split())) for _ in range(100)]
  count = 0
  for col in range(100):
    check = []
    for row in range(100):
      if board[row][col] == 1:
        check.append('N')
      if board[row][col] == 2:
        check.append('S')
    for i in range(1, len(check)):
      if check[i-1] == 'N' and check[i] == 'S':
        count += 1
  print(f"#{tc} {count}")