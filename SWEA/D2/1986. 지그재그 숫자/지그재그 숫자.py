T = int(input())
for tc in range(1, T+1):
    N = int(input())
    i = 1
    answer = 0
    for j in range(1, N+1):
        answer += j * i
        i = i * (-1)
    print(f"#{tc} {answer}")