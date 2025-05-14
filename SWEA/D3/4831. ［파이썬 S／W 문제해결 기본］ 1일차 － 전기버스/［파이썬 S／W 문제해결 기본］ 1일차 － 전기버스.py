T = int(input())
for tc in range(1, T+1):
    K, N, M = map(int, input().split())
    charge = list(map(int, input().split()))
    station = [-1] * (N + 1)
    for i in range(len(charge)):
        tmp = charge[i]
        station[tmp] = i
    possible = K
    count = 0
    for i in range(1, len(station)):
        possible -= 1
        if possible == -1:
            print(f"#{tc} 0")
            break
        if station[i] != -1:
            if station[i] != (M-1):
                if (charge[station[i]+1] - charge[station[i]]) > possible:
                    #print(f"충전: {charge[station[i]]}")
                    count += 1
                    possible = K
            elif station[i] == (M-1):
                if (N - charge[station[i]]) > possible:
                    #print(f"충전: {charge[station[i]]}")
                    count += 1
                    possible = K
    else:
        print(f"#{tc} {count}")