import sys
input = sys.stdin.readline
N, S, M = map(int, input().split())
V = list(map(int, input().split()))

dp = [[False] * (M+1) for _ in range(N+1)]
dp[0][S] = True

for i in range(N):
  for v in range(M+1):
    if dp[i][v]:
      if v + V[i] <= M:
        dp[i+1][v+V[i]] = True
      if v - V[i] >= 0:
        dp[i+1][v-V[i]] = True

answer = -1
for v in range(M, -1, -1):
  if dp[N][v]:
    answer = v
    break

print(answer)