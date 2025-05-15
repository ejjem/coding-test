import sys
input = sys.stdin.readline
M, N = map(int, input().split())
dp = [0] * 1000001
for i in range(2, 1000001):
    if i > N:
        break
    if dp[i] == 0:
        dp[i] = 1
        for j in range(i, 1000001, i):
            dp[j] = 1
        if M <= i and i <= N:
            print(i)