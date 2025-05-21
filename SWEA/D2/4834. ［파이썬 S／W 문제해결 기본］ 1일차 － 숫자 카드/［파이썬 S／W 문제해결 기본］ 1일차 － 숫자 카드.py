T = int(input())
for tc in range(1, T+1):
  N = int(input())
  number = list(map(int, list(input().rstrip())))
  dp = [0] * 10
  for i in range(N):
    dp[number[i]] += 1
  maximum_card = 0
  maximum_value = 0
  for i in range(len(dp)):
    if dp[i] >= maximum_value:
      maximum_card = i
      maximum_value = dp[i]
    
  print(f"#{tc} {maximum_card} {maximum_value}")