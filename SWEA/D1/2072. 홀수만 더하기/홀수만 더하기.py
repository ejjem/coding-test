answer = []
t = int(input())

for i in range(t):
  tmp = 0
  data = list(map(int, input().split()))
  for j in range(len(data)):
    if (data[j] % 2) == 1:
      tmp += data[j]
  answer.append(tmp)
  
for i in range(t):
  print(f"#{i + 1} {answer[i]}");