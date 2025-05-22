arr = list(input().rstrip())
for i in range(len(arr)):
  if ord('a') <= ord(arr[i]) <= ord('z'):
    arr[i] = chr(ord(arr[i]) - 32)
print(''.join(arr))