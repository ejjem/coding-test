import sys
input = sys.stdin.readline
K = int(input())
stack = []
for _ in range(K):
    tmp = int(input())
    if tmp == 0:
        stack.pop()
    else:
        stack.append(tmp)
print(sum(stack))