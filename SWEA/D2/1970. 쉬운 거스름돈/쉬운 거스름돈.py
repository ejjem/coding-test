T = int(input())
for tc in range(1, T+1):
    N = int(input())
    money = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    answer = [0] * len(money)

    for i in range(len(money)):
        while N >= money[i]:
            N -= money[i]
            answer[i] += 1
    print(f"#{tc}")
    print(" ".join(map(str, answer)))