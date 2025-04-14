import sys
input = sys.stdin.readline
N = int(input())
targets = []
for _ in range(N):
  tmp = int(input())
  targets.append(tmp)
stack = []
answer = []
num = 1
possible = True
for index in range(N):
  if num <= targets[index]:
    while num <= targets[index]:
      stack.append(num)
      answer.append("+")
      num += 1
    if stack[-1] == targets[index]:
     stack.pop()
     answer.append("-")
  else:
    if stack[-1] == targets[index]:
      stack.pop()
      answer.append("-")
    else:
      possible = False
      print("NO")
      break
if possible:
  print("\n".join(answer))