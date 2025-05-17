import sys
input = sys.stdin.readline
N = int(input())
count = 0
for i in range(1, N+1):
    if i < 100:
        count += 1
    elif 100 <= i and i < 1000:
        arr = list(map(int, list(str(i))))
        if (arr[0] - arr[1]) == (arr[1] - arr[2]):
            count += 1
print(count)