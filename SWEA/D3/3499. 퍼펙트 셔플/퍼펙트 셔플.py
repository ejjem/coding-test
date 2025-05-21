#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    if N % 2 == 0:
        even = True
        flag = N//2 - 1
    else:
        even = False
        flag = N//2
    origin = list(input().split())
    answer = []
    deck_1 = origin[:flag+1]
    deck_2 = origin[flag+1:]

    for i in range(len(deck_2)):
        answer.append(deck_1[i])
        answer.append(deck_2[i])
    if not even:
        answer.append(deck_1[-1])
    print(f"#{tc} {' '.join(answer)}")