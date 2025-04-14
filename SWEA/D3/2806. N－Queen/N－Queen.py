T = int(input())
for ts in range(1, T+1):
  N = int(input())
  answer = 0
  position = [0] * N
  def check(row):
    for i in range(row):
      if position[row] == position[i] or row - i == abs(position[row] - position[i]):
        return False
    return True
  
  def solve(row):
    global answer
    if row == N:
      answer += 1
      return
    for i in range(N):
      position[row] = i
      if check(row):
        solve(row+1)
  solve(0)
  print(f"#{ts} {answer}")