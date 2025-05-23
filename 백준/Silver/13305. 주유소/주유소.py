N = int(input())
road = list(map(int, input().split()))
price = list(map(int, input().split()))
minimum = price[0]
answer = 0

for i in range(N-1):
    if price[i] < minimum:
        minimum = price[i]
    answer += minimum * road[i]
print(answer)