#import sys
#sys.stdin = open('input.txt', 'r')
def palindrome(string):
  string_front = string[:len(string)//2]
  if len(string)%2 == 0:
    string_back = string[len(string)//2:]
  else:
    string_back = string[len(string)//2+1:]
  for i in range(len(string_front)):
    if string_front[i] != string_back[len(string_front)-1-i]:
      return False
  return True

for tc in range(1, 11):
  N = int(input())
  board = [ list(input().rstrip()) for _ in range(8)]
  count = 0
  for row in range(8):
    for col in range(8):
      # 가로 검사
      if col + N <= 8:
        tmp = board[row][col:col+N]
        if palindrome(tmp):
          #print(f"tmp: {''.join(tmp)}")
          count += 1
      if row + N <= 8:
        tmp_2 = []
        for i in range(row, row+N, 1):
          tmp_2.append(board[i][col])
        if palindrome(tmp_2):
          #print(f"tmp_2: {''.join(tmp_2)}")
          count += 1
  print(f"#{tc} {count}")