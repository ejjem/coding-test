T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    Ai = list(map(int, input().split()))
    Bj = list(map(int, input().split()))
    maximum = -float('inf')
    if N <= M:
        for i in range(M - N + 1):
            arr = Bj[i:i+N]
            tmp = 0
            for j in range(N):
                tmp += arr[j] * Ai[j]
            maximum = max(maximum, tmp)
        print(f"#{tc} {maximum}")
    else:
        for i in range(N - M + 1):
            arr = Ai[i:i+N]
            tmp = 0
            for j in range(M):
                tmp += arr[j] * Bj[j]
            maximum = max(maximum, tmp)
        print(f"#{tc} {maximum}")