T = int(input())
total_answer = []
for ts in range(1, T+1):
  N, L = map(int, input().split())
  ingredients = [tuple(map(int, input().split())) for _ in range(N)]
  dp = [0] * (L+1)
  for point, cal in ingredients:
    for c in range(L, cal-1, -1):
      dp[c] = max(dp[c], dp[c-cal] + point)  
  total_answer.append(f"#{ts} {max(dp)}")

print("\n".join(total_answer))