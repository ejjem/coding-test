import sys
input = sys.stdin.readline
T = int(input())
for tc in range(1, T+1):
    N = int(input())
    stack = [N]
    count = 0
    while stack:
        target = stack.pop()
        if target == 0:
            count += 1

        if target >= 3:
            stack.append(target-3)
        if target >= 2:
            stack.append(target-2)
        if target >= 1:
            stack.append(target-1)
    print(count)