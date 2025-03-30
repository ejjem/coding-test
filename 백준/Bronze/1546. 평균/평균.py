import sys
input = sys.stdin.readline

N = int(input())
score = [x for x in map(int, input().split())]
maximum = max(score)
tmp = 0
for i in range(N):
  tmp += float(score[i]) / maximum * 100

print(tmp / N)
