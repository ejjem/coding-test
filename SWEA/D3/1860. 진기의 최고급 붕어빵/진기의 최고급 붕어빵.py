T = int(input())
for tc in range(1, T+1):
    N, M, K = map(int, input().split())
    customers = list(map(int, input().split()))
    bread = 0
    last = max(customers)
    time = [False] * (last+1)
    for customer in customers:
        time[customer] = True
    for i in range(last + 1):
        if i > 0 and i % M == 0:
            bread += K
        if time[i]:
            if bread > 0:
                bread -= 1
            else:
                print(f"#{tc} Impossible")
                break
    else:
        print(f"#{tc} Possible")