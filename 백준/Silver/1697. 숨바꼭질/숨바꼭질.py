from collections import deque
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = [0] * 100001
queue = deque()
queue.append(N)
while queue:
  point = queue.popleft()
  if point == K:
    break
  targets = [point - 1, point + 1, point * 2]
  for target in targets:
    if 0 <= target <= 100000 and arr[target] == 0:
      arr[target] = arr[point] + 1
      queue.append(target)
print(arr[K])