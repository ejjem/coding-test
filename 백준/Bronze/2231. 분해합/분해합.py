import sys
input = sys.stdin.readline

N = int(input())

for i in range(1, N+1):
  num = sum(map(int, str(i)))
  total_num = i + num
  if total_num == N:
    print(i)
    break
  elif i == N:
    print(0)
    break
