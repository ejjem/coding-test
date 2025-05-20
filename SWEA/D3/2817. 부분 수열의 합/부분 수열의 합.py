from itertools import combinations
T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())
    number = list(map(int, input().split()))
    answer = 0
    for i in range(1, N+1):
        for combination in combinations(number, i):
            if sum(combination) == K:
              answer += 1
    print(f"#{tc} {answer}")