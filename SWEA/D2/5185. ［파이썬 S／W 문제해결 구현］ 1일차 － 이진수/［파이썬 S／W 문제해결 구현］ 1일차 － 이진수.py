T = int(input())
binary = ['0000', '0001', '0010', '0011', '0100', '0101', '0110', '0111', '1000', '1001', '1010', '1011', '1100', '1101', '1110', '1111']
for tc in range(1, T+1):
  N, number = input().split()
  target = list(number)
  answer = []
  for i in range(int(N)):
    if target[i] == 'A': #10
      answer.append(binary[10])
    elif target[i] == 'B': #11
      answer.append(binary[11])
    elif target[i] == 'C': #12
      answer.append(binary[12])
    elif target[i] == 'D': #13
      answer.append(binary[13])
    elif target[i] == 'E': #14
      answer.append(binary[14])
    elif target[i] == 'F': #15
      answer.append(binary[15])
    else:
      answer.append(binary[int(target[i])])
  print(f"#{tc} {''.join(answer)}")