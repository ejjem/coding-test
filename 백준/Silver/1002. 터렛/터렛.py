import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
  x_1, y_1, r_1, x_2, y_2, r_2 = map(int, input().split())
  distance = ( (x_1 - x_2)**2 + (y_1 - y_2)**2 ) ** 0.5
  if x_1 == x_2 and y_1 == y_2 and r_1 == r_2:
    print(-1)
  elif distance > r_1 + r_2:
    print(0)
  elif distance < abs(r_1 - r_2):
    print(0)
  elif distance == 0 and r_1 != r_2:
    print(0) 
  elif distance == r_1 + r_2:
    print(1)
  elif distance == abs(r_1 - r_2):
    print(1)
  else:
    print(2)