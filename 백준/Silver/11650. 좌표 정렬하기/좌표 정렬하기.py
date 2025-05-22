import sys
input = sys.stdin.readline
N = int(input())
number = [tuple(map(int, input().split())) for _ in range(N)]
number.sort(key=lambda x: (x[0], x[1]))
for a, b in number:
    print(f"{a} {b}")