import sys
input = sys.stdin.readline
N = int(input())
arr = [0] * 1000
arr[0] = 1
arr[1] = 3
index = 2
if N == 1:
  print(arr[0])
elif N == 2:
  print(arr[1])
else:
  while index < 1000:
    arr[index] = 2*arr[index-2]+arr[index-1]
    if index == N-1:
      print(arr[index]%10007)
      break
    index += 1