import sys
input = sys.stdin.readline

N = int(input())
file = [str(input()) for _ in range(N)]
answer = []
for i in range (len(file[0])): 
  flag = 1
  tmp = file[0][i]
  for j in range(1, N):
    if file[j][i] != tmp:
      flag = 0
  if flag == 1:
    answer.append(tmp)
  else:
    answer.append("?")

print("".join(answer))
    


  