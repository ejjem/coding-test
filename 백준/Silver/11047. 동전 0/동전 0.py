import sys
input = sys.stdin.readline
N, K = map(int, input().split())
coin = [int(input()) for _ in range(N)]
answer = 0
for i in range(len(coin)-1, -1, -1):
    if coin[i] <= K:
        tmp = K // coin[i]
        answer += tmp
        K -= tmp * coin[i]
        if K == 0:
            print(answer)
            break