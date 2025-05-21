#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    dp = [0] * 5001
    N = int(input())
    for _ in range(N):
        A, B = map(int, input().split())
        for i in range(A, B+1):
            dp[i] += 1
    P = int(input())
    answer = []
    for _ in range(P):
        num = int(input())
        answer.append(str(dp[num]))
    print(f"#{tc} {' '.join(answer)}")