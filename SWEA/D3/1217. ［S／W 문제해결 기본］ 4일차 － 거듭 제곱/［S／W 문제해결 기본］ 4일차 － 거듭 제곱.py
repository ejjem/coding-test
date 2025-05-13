for _ in range(10):
    tc = int(input())
    N, M = map(int, input().split())
    def cal(tmp, N, M):
        if M == 0:
            return tmp
        tmp = tmp * N
        return cal(tmp, N, M-1)
    print(f"#{tc} {cal(1, N, M)}")