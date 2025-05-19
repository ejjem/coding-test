for tc in range(1, 11):
  a, b = input().split()
  N = int(a)
  number = list(map(int, b))
  
  def search(arr):
    for i in range(1, len(arr)):
      if arr[i] == arr[i-1]:
        tmp = []
        tmp.extend(arr[:i-1])
        tmp.extend(arr[i+1:])
        return search(tmp)
    return arr
  answer = search(number)
  print(f"#{tc} {''.join(map(str, answer))}")