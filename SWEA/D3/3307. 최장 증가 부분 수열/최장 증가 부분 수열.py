T = int(input())
for tc in range(1, T+1):
  N = int(input())
  number = list(map(int, input().split()))
  dp = [1] * N
  for i in range(1, N):
    for j in range(i):
      if number[j] < number[i]:
        dp[i] = max(dp[i], dp[j] + 1)
  #print(dp)
  print(f"#{tc} {max(dp)}")