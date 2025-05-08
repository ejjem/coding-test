for _ in range(10):
  tc = int(input())
  ladder = [ list(map(int, input().split())) for _ in range(100)]
  for i in range(100):
    if ladder[99][i] == 2:
      start = i
  y = 99    
  while True:
    if y == 0:
      break
    if 0 <= start-1 and ladder[y][start-1] == 1:
      while 0 <= start-1 and ladder[y][start-1] == 1:
        start -= 1
    elif start+1 <= 99 and ladder[y][start+1] == 1:
      while start+1 <= 99 and ladder[y][start+1] == 1:
        start += 1
    y -= 1
  print(f"#{tc} {start}")