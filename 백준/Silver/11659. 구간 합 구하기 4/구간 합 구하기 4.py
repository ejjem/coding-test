import sys
input = sys.stdin.readline

N, M = map(int, input().split())
number = list(map(int, input().split()))
answer = []
sum = [0]
tmp = 0
for i in range(N):
  tmp += number[i]
  sum.append(tmp)

for _ in range(M):
  a, b = map(int, input().split())
  answer.append(sum[b] - sum[a-1])

print("\n".join(map(str, answer)))
  


