T = int(input())
for tc in range(1, T+1):
    N = int(input())
    count = 1
    number = set()
    while True:
        if len(number) == 10:
            print(f"#{tc} { (count-1) * N}")
            break
        arr = list(str(N*count))
        for i in range(len(arr)):
            number.add(arr[i])
        count += 1