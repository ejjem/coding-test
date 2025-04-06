answer = []
for ts in range(1, 11):
  N = int(input())
  box = list(map(int, input().split()))
  flag = False
  for i in range(N):
    box.sort()
    if box[-1] - box[0] < 1:
      flag = True
      break
    else:
      box[-1] -= 1
      box[0] += 1
  if not flag:
    box.sort()
  answer.append(f"#{ts} {box[-1] - box[0]}")
print("\n".join(answer))