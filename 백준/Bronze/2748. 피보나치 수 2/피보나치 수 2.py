import sys
input = sys.stdin.readline

n = int(input())
num1 = 0
num2 = 1
# 0, 1, 1, 2, 3, 5, ...
for i in range(2, n + 1):
  if i % 2 == 0:
    num1 = num1 + num2
  else:
    num2 = num1 + num2

if n % 2 == 0:
  print(num1)
else:
  print(num2)
  
  
  