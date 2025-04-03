import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = []
for _ in range(N):
  data.append(list(map(int, input().rstrip())))

answer = 1
max_length = min(N, M) - 1
def search(max_length, data):
  for length in range(max_length, 0, -1):
    for row in range(N):
      if row + length >= N:
        break
      for col in range(M):
        if col + length >= M:
          break
        standard = data[row][col]
        targets = [data[row+length][col], data[row][col+length], data[row+length][col+length]]
        if all(target == standard for target in targets):
            return length     
  return 0
      
answer = search(max_length, data) + 1
print(answer ** 2)



    
  
  