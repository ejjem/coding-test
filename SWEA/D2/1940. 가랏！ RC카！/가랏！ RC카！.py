T = int(input())
for tc in range(1, T+1):
  N = int(input())
  answer = 0
  speed = 0
  for _ in range(N):
    command = list(input())
    if command[0] == '0':
      answer += speed
    elif command[0] == '1':
      speed += int(command[2])
      answer += speed
     
    elif command[0] == '2':
      speed -= int(command[2])
      if speed <= 0:
        speed = 0
      answer += speed
  print(f"#{tc} {answer}")  