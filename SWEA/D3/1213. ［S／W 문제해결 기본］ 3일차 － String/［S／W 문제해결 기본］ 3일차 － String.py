for _ in range(1, 11):
    tc = int(input())
    search = list(input())
    target = list(input())
    count = 0
    for i in range(len(target) - len(search) + 1):
        tmp = target[i:i+len(search)]
        if tmp == search:
            count += 1
    print(f"#{tc} {count}")