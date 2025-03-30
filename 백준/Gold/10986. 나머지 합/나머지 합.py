import sys
input = sys.stdin.readline

N, M = map(int, input().split())
number = [x for x in map(int, input().split())]
number_sum = [0] * N
remain = [0] * M
number_sum[0] = number[0]
for i in range(1, N):
  number_sum[i] = number_sum[i-1] + number[i]

for i in range(N):
  tmp = number_sum[i] % M
  remain[tmp] += 1
cnt = remain[0]
for i in range(M):
  if remain[i] > 1:
    cnt += ( remain[i] * ( remain[i] - 1) // 2 )
print(cnt)