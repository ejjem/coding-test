dp = [True] * 10001

for i in range(1, len(dp)):
    if dp[i]:
        print(i)
    arr = list(map(int, list(str(i))))
    if i + sum(arr) < len(dp):
        dp[i + sum(arr)] = False