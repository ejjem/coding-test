import sys
input = sys.stdin.readline
K, N = map(int, input().split())
LANs = []
LANs = [int(input()) for _ in range(K)]
left = 1
right = max(LANs)
answer = 0
while left <= right:
    count = 0
    for LAN in LANs:
        length = (left + right) // 2
        count += LAN // length
    if count >= N:
        answer = length
        left = length + 1
    else:
        right = length - 1
print(answer)