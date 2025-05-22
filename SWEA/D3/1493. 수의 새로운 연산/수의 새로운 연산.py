T = int(input())
for tc in range(1, T+1):
  p, q = map(int, input().split())
  num = 0
  i = 1
  find_p, find_q = False, False
  p_x, p_y = 0, 0
  q_x, q_y = 0, 0
  line_p, line_q = 0, 0
  while True:
    if find_p and find_q:
      break
    if num + i >= p and not find_p:
      find_p = True
      tmp = num + i - p
      p_x = i - tmp
      p_y = 1 + tmp
    if num + i >= q and not find_q:
      find_q = True
      tmp = num + i - q
      q_x = i - tmp
      q_y = 1 + tmp
    num += i
    i += 1
  
  x, y = p_x + q_x, p_y + q_y
  gap = y - 1
  answer = sum(list(range(1, x + gap +1))) - gap
  print(f"#{tc} {answer}")