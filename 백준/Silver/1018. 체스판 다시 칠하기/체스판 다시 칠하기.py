import sys
input = sys.stdin.readline

N, M = map(int, input().split())
# N: 세로, M: 가로
board = []
for i in range(N):
  board.append(input().rstrip())
minimum = float('inf')

for row_start in range(N-7):
  for col_start in range(M-7):
    case1, case2 = 0, 0
    for row in range(8):
      for col in range(8):
        if (row + col) % 2 == 0:
          if board[row_start + row][col_start + col] == 'W':
            case2 += 1
          else:
            case1 += 1
        else: 
          if board[row_start + row][col_start + col] == 'W':
            case1 += 1
          else:
            case2 += 1
    minimum = min(minimum, case1, case2)
print(minimum)