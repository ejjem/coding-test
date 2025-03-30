import sys
input = sys.stdin.readline
N, M = map(int, input().split())
number = [[0] * (N+1) ]
for _ in range(N):
  tmp = [0] + list(map(int, input().split()))
  number.append(tmp)
number_sum = [ [0] * (N + 1) for _ in range(N + 1)]
for i in range(1, N+1):
  for j in range(1, N+1):
    number_sum[i][j] = number_sum[i][j-1] + number_sum[i-1][j] - number_sum[i-1][j-1] + number[i][j]

answer = []

for i in range(M):
  x1, y1, x2, y2 = map(int, input().split())
  tmp = number_sum[x2][y2] - number_sum[x1-1][y2] - number_sum[x2][y1-1] + number_sum[x1-1][y1-1]
  answer.append(tmp)

print("\n".join(map(str, answer)))
