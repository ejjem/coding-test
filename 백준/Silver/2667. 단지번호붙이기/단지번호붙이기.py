import sys
input = sys.stdin.readline

N = int(input())
house = [[x for x in map(int, input().rstrip())] for _ in range(N)]
answer = []
visited = set()

def DFS(node):
  global house
  global visited
  global answer
  stack = [node]
  visited.add(node)
  directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
  cnt = 1
  while stack:
    x, y = stack.pop()
    for dx, dy in directions:
      target_x = x + dx
      target_y = y + dy
      if 0 <= target_x < N and 0 <= target_y < N:
        if house[target_x][target_y] == 1 and (target_x, target_y) not in visited:
          stack.append((target_x, target_y))
          visited.add((target_x, target_y))
          cnt += 1
  answer.append(cnt)
          
count = 0

for i in range(N):
  for j in range(N):
    if house[i][j] == 1 and (i, j) not in visited:
      DFS((i, j))
      count += 1

print(count)
print("\n".join(map(str, sorted(answer))))