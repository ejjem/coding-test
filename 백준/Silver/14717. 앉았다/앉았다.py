import sys
from itertools import combinations
input = sys.stdin.readline

A, B = map(int, input().split())
total = 18 * 17 / 2
win = 0
if A == B:
  lose = 10 - A
  win = total - lose
else:
  card = list(range(1, 11)) * 2
  card.remove(A)
  card.remove(B)
  score = (A + B) % 10
  for a, b in combinations(card, 2):
    if a != b and (a + b)%10 < score:
      win +=1
answer = win / total
print(f"{answer:.3f}")