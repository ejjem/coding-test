import sys
input = sys.stdin.readline
N = int(input())
number = list(map(int, input().split()))
number.sort()
count = 0

for i in range(N):
  target =  number[i]
  start_index = 0
  end_index = N-1
  while start_index < end_index :
    if number[start_index] + number[end_index] == target:
      if start_index != i and end_index != i:
        count += 1
        break
      elif start_index == i:
        start_index += 1
      elif end_index == i:
        end_index -= 1
    elif number[start_index] + number[end_index] < target:
      start_index += 1
    else:
      end_index -= 1

print(count)