import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

answer = float('inf')

for row in range(N - 7):
  for col in range(M - 7):
    cnt_1, cnt_2 = 0, 0
    
    for i in range(8):
      for j in range(8):
        if (i + j) % 2 == 0:
          if board[row + i][col + j] != 'W':
            cnt_1 += 1
          if board[row + i][col + j] != 'B':
            cnt_2 += 1
        else:
          if board[row + i][col + j] != 'B':
            cnt_1 += 1
          if board[row + i][col + j] != 'W':
            cnt_2 += 1
    
    answer = min(answer, cnt_1, cnt_2)

print(answer)
      