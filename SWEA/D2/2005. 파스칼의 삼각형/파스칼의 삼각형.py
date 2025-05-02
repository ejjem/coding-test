T = int(input())
for tc in range(1, T+1):
  N = int(input())
  tri = []
  for i in range(1, N+1):
    tmp = [1] * i
    if len(tmp) >= 3:
      past = tri[i-2]
      for j in range(1, i-1):
        tmp[j] = past[j] + past[j-1]
    tri.append(tmp)
  print(f"#{tc}")
  for row in tri:
    print(" ".join(map(str, row)))