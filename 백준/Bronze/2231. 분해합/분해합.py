import sys
input = sys.stdin.readline

N = int(input())

start = max(1, N - 9 * len(str(N)))

for i in range(start, N + 1):
    num = sum(map(int, str(i)))
    if i + num == N:
        print(i)
        break
else:
    print(0)