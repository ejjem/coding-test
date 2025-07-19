T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    if N > M:
        A, B = B, A
        N, M = M, N

    max_sum = -float('inf')
    for i in range(M - N + 1):
        temp_sum = 0
        for j in range(N):
            temp_sum += A[j] * B[i + j]
        max_sum = max(max_sum, temp_sum)

    print(f"#{tc} {max_sum}")