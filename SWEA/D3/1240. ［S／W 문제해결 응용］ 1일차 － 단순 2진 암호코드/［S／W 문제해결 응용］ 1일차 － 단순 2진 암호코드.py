T = int(input())
for tc in range(1, T+1):
  N, M = map(int, input().split())
  data = [ list(input().rstrip()) for _ in range(N)]
  target = []
  # 암호문 위치 찾기
  for row in data:
    find = False
    if '1' in row:
      for i in range(len(row)-1, -1, -1):
        if row[i] == '1':
          target.extend(row[i-55:i+1])
          find = True
          break
    if find:
      break
  # 암호문 분석
  decoding = ('0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011')
  decode = []
  for i in range(0, 56, 7):
    tmp = target[i:i+7]
    decode.append(decoding.index("".join(tmp)))
  # 암호문 확인
  decode_sum = 0
  for i in range(0, 8, 2):
    decode_sum += decode[i] * 3
  for i in range(1, 8, 2):
    decode_sum += decode[i]
  if decode_sum % 10 == 0:
    print(f"#{tc} {sum(decode)}")
  else:
    print(f"#{tc} 0")