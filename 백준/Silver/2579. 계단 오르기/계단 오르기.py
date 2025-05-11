import sys
input = sys.stdin.readline
N = int(input())
stairs = [ int(input()) for _ in range(N)]
dp = [0] * N
dp[0] = stairs[0]
if N == 1:
  print(dp[0])
else:
  dp[1] = stairs[0] + stairs[1]
  for i in range(2, N):
    dp[i] = max(dp[i-3] + stairs[i-1] + stairs[i], dp[i-2] + stairs[i])
  print(dp[N-1])