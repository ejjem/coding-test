import sys
input = sys.stdin.readline
N = int(input())
work = [tuple(map(int, input().split())) for _ in range(N)]
dp = [0] * (N+1) # 0 ~ N
for i in range(N):
  day, pay = work[i]
  dp[i+1] = max(dp[i+1], dp[i])
  if day + i <= N:
    dp[i+day] = max(dp[i+day], dp[i]+pay)
print(max(dp))