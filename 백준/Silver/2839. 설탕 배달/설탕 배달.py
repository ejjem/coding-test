import sys
input = sys.stdin.readline
N = int(input())
possible = [-1] * (N+1)
possible[N] = 0

for i in range(N, -1, -1):
  if possible[i] != -1:
    if 0 <= i-5:
      if possible[i-5] == -1:
        possible[i-5] = possible[i] + 1
      elif possible[i-5] > possible[i] + 1:
        possible[i-5] = possible[i] + 1
    if 0 <= i-3:
      if possible[i-3] == -1:
        possible[i-3] = possible[i] + 1
      elif possible[i-3] > possible[i] + 1:
        possible[i-3] = possible[i] + 1   
print(possible[0])