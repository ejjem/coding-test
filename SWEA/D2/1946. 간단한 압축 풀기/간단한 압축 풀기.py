T = int(input())
for tc in range(1, T+1):
    N = int(input())
    data = []
    for _ in range(N):
        alphabet, num = input().split()
        data.append((alphabet, int(num)))
    print(f"#{tc}")
    i = 0
    tmp = []
    while i < len(data):
        alphabet, num = data[i]
        while len(tmp) < 10 and num > 0:
            tmp.append(alphabet)
            num -= 1
            if len(tmp) == 10:
                print(''.join(tmp))
                tmp.clear()
        i += 1
    if tmp:
        print(''.join(tmp))