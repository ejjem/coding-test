import sys
input = sys.stdin.readline

N = int(input())
data = [int(input()) for _ in range(N)]
answer = [0] * N

def solve(target):
  maximum = 0
  for i in range(1, 46):
    if i * (i + 1) // 2 >= target:
      maximum = i
      break
  
  for i in range(1, maximum):
    for j in range(1, maximum):
      for k in range(1, maximum):
        tmp = (i * (i + 1) // 2) + (j * (j + 1) // 2) + (k * (k + 1) // 2)
        if target == tmp:
          return 1
  return 0

for i in range(N):
  answer[i] = solve(data[i])

print("\n".join(map(str, answer)))