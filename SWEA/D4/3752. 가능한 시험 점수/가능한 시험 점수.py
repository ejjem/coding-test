T = int(input())
for tc in range(1, T+1):
  N = int(input())
  points = [x for x in map(int, input().split())]
  max_score = sum(points)
  dp = [0] * (max_score + 1)
  dp[0] = 1
  for point in points:
    for i in range(max_score, -1, -1):
      if dp[i] == 1:
        dp[i + point] = 1 
  count = sum(dp)
  print(f"#{tc} {count}")