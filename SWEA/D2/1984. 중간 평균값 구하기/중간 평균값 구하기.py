T = int(input())
for tc in range(1, T+1):
    number = list(map(int, input().split()))
    number.sort()
    number.remove(number[0])
    number.remove(number[-1])
    answer = sum(number) / len(number)
    print(f"#{tc} {round(answer)}")