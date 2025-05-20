T = int(input())
for tc in range(1, T+1):
    low, high, time = map(int, input().split())
    if time > high:
        print(f"#{tc} -1")
    elif low <= time <= high:
        print(f"#{tc} 0")
    elif low > time:
        print(f"#{tc} {low - time}")