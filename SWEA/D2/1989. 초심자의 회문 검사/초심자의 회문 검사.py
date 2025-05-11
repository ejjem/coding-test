#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
  string = list(input())
  string_front = string[:len(string)//2]
  if len(string)%2 == 0:
    string_back = string[len(string)//2:]
  else:
    string_back = string[len(string)//2+1:]
  palindrome = True
  for i in range(len(string_front)):
    if string_front[i] != string_back[len(string_back)-1-i]:
      palindrome = False
  if palindrome:
    print(f"#{tc} 1")
  else:
    print(f"#{tc} 0")