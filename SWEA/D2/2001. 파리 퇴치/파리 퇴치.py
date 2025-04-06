T = int(input())
answer = []
for ts in range(1, T+1):
  N, M = map(int, input().split())
  maximum = -float("inf")
  fly = [ list(map(int, input().split())) for _ in range(N)]
  fly_sum = [ [0] * (N+1) for _ in range(N+1)]
  fly_sum[1][1] = fly[0][0]
  for i in range(2, N+1):
    fly_sum[1][i] = fly_sum[1][i-1] + fly[0][i-1]
    fly_sum[i][1] = fly_sum[i-1][1] + fly[i-1][0]
  for i in range(2, N+1):
    for j in range(2, N+1):
      fly_sum[i][j] = fly_sum[i-1][j] + fly_sum[i][j-1]  + fly[i-1][j-1] - fly_sum[i-1][j-1]
  for i in range(M, N+1):
    for j in range(M, N+1):
      tmp = fly_sum[i][j] - fly_sum[i-M][j] - fly_sum[i][j-M] + fly_sum[i-M][j-M]
      maximum = max(maximum, tmp)
  answer.append(f"#{ts} {maximum}")

print("\n".join(answer))