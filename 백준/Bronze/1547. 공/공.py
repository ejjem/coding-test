import sys
input = sys.stdin.readline

M = int(input())
cup = [1, 2, 3]
for _ in range(M):
  i, j = map(int, input().split())
  if i != j:
    a = cup.index(i)
    b = cup.index(j)
    cup[a], cup[b] = cup[b], cup[a]
  i, j = 0, 0
  
print(cup[0])