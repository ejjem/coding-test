import sys
input = sys.stdin.readline

N = int(input())
data = [tuple(map(int, input().split())) for _ in range(N)]
dp = [0] * (N+1)

for present_day in range(N):
  day, pay = data[present_day]
  dp[present_day + 1] = max(dp[present_day + 1], dp[present_day])
  if present_day + day < N + 1:
    dp[present_day + day] = max(dp[present_day + day], dp[present_day] + pay)

print(dp[N])