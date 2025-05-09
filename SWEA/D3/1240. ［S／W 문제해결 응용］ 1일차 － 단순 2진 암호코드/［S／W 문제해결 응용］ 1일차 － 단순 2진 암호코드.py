T = int(input())
for tc in range(1, T+1):
  N, M = map(int, input().split())
  board = [ list(input().rstrip()) for _ in range(N)]
  decoding = ('0001101', '0011001', '0010011', '0111101', '0100011', '0110001', '0101111', '0111011', '0110111', '0001011')
  target = []
  find = False
  for row in board:
    if '1' in row:
      for i in range(len(row)-1, -1, -1):
        if row[i] == '1':
          target.extend(row[i-55:i+1])
          find = True
          break
    if find:
      break
  arr = []
  for j in range(7, 57, 7):
    tmp = target[j-7:j]
    tmp_check = "".join(tmp)
    if tmp_check in decoding:
      arr.append(decoding.index(tmp_check))
  if len(arr) == 8:
    arr_odd = []
    arr_even = []
    for i in range(0, len(arr), 2):
      arr_even.append(arr[i])
    for j in range(1, len(arr), 2):
      arr_odd.append(arr[j])
    cal = (sum(arr_odd) + sum(arr_even)*3) % 10
    if cal == 0:
      print(f"#{tc} {sum(arr)}")
    else:
      print(f"#{tc} 0")