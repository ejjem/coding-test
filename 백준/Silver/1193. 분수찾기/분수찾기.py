import sys
input = sys.stdin.readline
N = int(input())

line = 0
line_num = 0

for i in range(1, 10000001):
    if line + i >= N:
        line_num = i
        break
    line += i

idx_in_line = N - line

if line_num % 2 == 0:  # ↙
    a = idx_in_line
    b = line_num - idx_in_line + 1
else:  # ↗
    a = line_num - idx_in_line + 1
    b = idx_in_line

print(f"{a}/{b}")
