T = int(input())
for ts in range(1, T+1):
  N = int(input())
  target = [list(map(int, input().split())) for _ in range(N)]
  target_90 = []
  target_180 = []
  target_270 = []
  for i in range(N):
    tmp = []
    for j in range(N-1, -1, -1):
      tmp.append(target[j][i])    
    target_90.append(tmp)
  for i in range(N):
    tmp = []
    for j in range(N-1, -1, -1):
      tmp.append(target_90[j][i])
    target_180.append(tmp)
  for i in range(N):
    tmp = []
    for j in range(N-1, -1, -1):
      tmp.append(target_180[j][i])
    target_270.append(tmp)
  
  print(f"#{ts}")
  for i in range(N):
    print(f'{ "".join(map(str, target_90[i])) } { "".join(map(str, target_180[i])) } { "".join(map(str, target_270[i])) }')