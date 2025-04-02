import sys
from itertools import combinations
input = sys.stdin.readline

tall = []
for _ in range(9):
  tall.append(int(input()))

number = list(range(9))
total = sum(tall)
for x, y in combinations(number, 2):
  if total - tall[x] - tall[y] == 100:
    tmp1 = tall[x]
    tmp2 = tall[y]
    tall.remove(tmp1)
    tall.remove(tmp2)
    break

tall.sort()
print("\n".join(map(str, tall)))
    
  