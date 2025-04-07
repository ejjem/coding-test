import sys
input = sys.stdin.readline
number = list(range(1, 4))

M = int(input())
for _ in range(M):
  X, Y = map(int, input().split())
  index_X, index_Y = number.index(X), number.index(Y)
  number[index_X], number[index_Y] = number[index_Y], number[index_X]
print(number[0])