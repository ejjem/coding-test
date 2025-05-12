import sys
input = sys.stdin.readline
N = int(input())
dp = [0] * (N+1)
dp[0] = 0
dp[1] = 1
if N >= 2:
    for i in range(2, len(dp)):
        dp[i] = dp[i-1] + dp[i-2]
print(dp[N])