T = int(input())
answer = []

for i in range(T):
  N = int(input())
  price = list(map(int, input().split()))
  price.reverse()
  max = price[0]
  tmp = 0
  for j in range (1, N):
    if price[j] > max:
      max = price[j]
    elif price[j] < max:
      tmp += max - price[j]
  answer.append(f"#{i + 1} {tmp}")      
  
# 답안 출력
print("\n".join(answer))