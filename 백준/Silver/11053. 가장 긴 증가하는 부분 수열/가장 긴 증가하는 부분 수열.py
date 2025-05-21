import sys
input = sys.stdin.readline
N = int(input())
number = list(map(int, input().split()))
dp = [1] * N
for i in range(N-2, -1, -1):
  for j in range(i+1, N):
    if number[i] < number[j]:
      dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))