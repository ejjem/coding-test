import sys
input = sys.stdin.readline
N = int(input())
data = [tuple(map(int, input().split())) for _ in range(N)]
data.sort(key=lambda x: (x[1], x[0]))
count = 1
time = data[0][1]
for i in range(1, len(data)):
    start, end = data[i]
    if start >= time:
        time = end
        count += 1
print(count)