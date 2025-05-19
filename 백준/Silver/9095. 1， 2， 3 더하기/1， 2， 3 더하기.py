import sys
input = sys.stdin.readline
T = int(input())
dp = [0] * 12
dp[0] = 1
for i in range(1, 12):
    if i >= 1:
        dp[i] += dp[i-1]
    if i >= 2:
        dp[i] += dp[i-2]
    if i >= 3:
        dp[i] += dp[i-3]
for _ in range(T):
    N = int(input())
    print(dp[N])