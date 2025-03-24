T = int(input())
answer = []
for num in range(1, T+1):
  N = int(input())
  data = [[0]* N for _ in range(N)]
  row, col = 0, 0
  data[row][col] = 1
  cnt = 1
  index = N

  def print_matrix(matrix):
    for row in matrix:
        print(" ".join(f"{x}" for x in row))
          
  for i in range(2, N ** 2 + 1):
    if cnt == (4*index - 4):
      index -= 2
      cnt = 0
      
    if cnt <= index - 1:
      cnt += 1
      col += 1
        
    elif index <= cnt <= 2*index - 2:
      cnt += 1
      row += 1
        
    elif 2*index - 1 <= cnt <= 3*index - 3:
      cnt += 1
      col -= 1
        
    elif 3*index - 2 <= cnt <= 4*index - 5:
      cnt += 1
      row -= 1
        
    data[row][col] = i
  
  answer.append(f"#{num}")
  for row in data:
    answer.append(" ".join(f"{x}" for x in row)) 
    
print("\n".join(answer))
    
 