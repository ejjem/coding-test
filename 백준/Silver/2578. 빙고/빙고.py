import sys
input = sys.stdin.readline
board = [[x for x in map(int, input().split())] for _ in range(5)]
anounce = [x for _ in range(5) for x in map(int, input().split())]
def start(board, anounce):
  bingo = 0
  
  for i in range(len(anounce)):
    target = anounce[i]
    for j in range(5):
      if target in board[j]:
        board[j][board[j].index(target)] = -1
    
    if i >= 4:
      for row in board:
        if all(x == -1 for x in row):
          bingo += 1
          
      for col in range(5):
        if all(board[row][col] == -1 for row in range(5)):
          bingo+=1
            
      if all(board[k][k] == -1 for k in range(5)):
        bingo += 1

      if all(board[k][4-k] == -1 for k in range(5)):
        bingo += 1
        
      if bingo >= 3:
        print(i + 1)
        return
      else:
          bingo = 0
        

start(board, anounce)
    
  



