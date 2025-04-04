from itertools import combinations

T = int(input())
answer = []
for i in range(T):
  num, N = map(int, input().split())
  length = len(str(num))
  index = list(range(length))
  number = list(str(num))
  stack = [number]
  maximum = 0
  for _ in range(N):
    checked = set()
    for a, b in combinations(index, 2):
      for number in stack:
        number = list(number)
        number[a], number[b] = number[b], number[a]
        if tuple(number) not in checked:
          checked.add(tuple(number))
    stack = list(checked)
  
  for number in stack:
    maximum = max(maximum, int("".join(number)))
  
  answer.append(f"#{i+1} {maximum}")

print("\n".join(answer)) 