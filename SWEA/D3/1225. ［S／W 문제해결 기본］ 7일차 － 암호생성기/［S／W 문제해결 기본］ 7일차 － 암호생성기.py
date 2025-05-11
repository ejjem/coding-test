#import sys
#sys.stdin = open("input.txt", "r")

from collections import deque
for _ in range(10):
  tc = int(input())
  data = list(map(int, input().split()))
  queue = deque()
  queue.extend(data)
  index = [1, 2, 3, 4, 5]
  i = 0
  while True:
    target = queue.popleft()
    if target > index[i]:
      target -= index[i]
      queue.append(target)
      i = (i+1)%5
    else:
      target = 0
      queue.append(target)
      break
  print(f"#{tc} {' '.join(map(str,queue))}")  