answer = []
for n in range(1, 11):
  N = input()
  tower = [int(x) for x in input().split()]
  count = 0
  for i in range (2, len(tower) - 2):
    if (tower[i] > tower[i-2]) and(tower[i] > tower[i-1]) and (tower[i] > tower[i + 1]) and (tower[i] > tower[i + 2]):
      count += tower[i] - max(tower[i-1], tower[i-2], tower[i+1], tower[i+2])
  answer.append(f"#{n} {count}")

print("\n".join(answer))

