import sys
input = sys.stdin.readline

T = int(input())
for i in range(T):
    N = int(input())
    if N == 0:
        print("1 0")
    elif N == 1:
        print("0 1")
    else:
        dp = [[0, 0]] * (N + 1)
        dp[0] = [1, 0]
        dp[1] = [0, 1]
        for i in range(2, N+1):
            count_0, count_1 = dp[i-2]
            count_00, count_11 = dp[i-1]
            dp[i] = [count_0 + count_00, count_1 + count_11]
        answer_0, answer_1 = dp[N]
        print(f"{answer_0} {answer_1}")