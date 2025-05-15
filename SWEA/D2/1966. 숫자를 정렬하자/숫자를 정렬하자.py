T = int(input())
for tc in range(1, T+1):
    N = int(input())
    number = list(map(int, input().split()))
    number.sort()
    print(f"#{tc} {' '.join(list(map(str, number)))}")