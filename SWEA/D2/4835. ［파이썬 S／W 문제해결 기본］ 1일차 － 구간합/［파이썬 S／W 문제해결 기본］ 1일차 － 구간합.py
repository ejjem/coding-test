T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    number = list(map(int, input().split()))
    maximum = sum(number[:M])
    minimum = maximum
    window = maximum
    for i in range(M, N):
        window = window - number[i-M] + number[i]
        maximum = max(window, maximum)
        minimum = min(window, minimum)
    print(f"#{tc} {maximum - minimum}")