from collections import deque
T = int(input())
for ts in range(1, T + 1):
  N = int(input())
  farm = [list(map(int, list(input()))) for _ in range(N)]
  middle = N//2
  answer = 0
  index = 1
  index_list = deque()
  index_list.append(middle)
  for i in range(middle+1):
    for j in index_list:
      answer += farm[i][j]
    if index_list[0] != 0:
      index_list.appendleft(middle - index)
      index_list.append(middle + index)
      index += 1
  for i in range(middle+1, N):
    index_list.popleft()
    index_list.pop()
    for j in index_list:
      answer += farm[i][j]
    
  print(f"#{ts} {answer}")