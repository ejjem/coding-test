import sys
input = sys.stdin.readline

T = int(input())
answer = [0] * T
tri = []
for i in range(1, 45):
  tri.append(i*(i+1)//2)

def search(K, tri, num):
  for i in tri:
    for j in tri:
      for k in tri:
        if i + j + k == K:
          answer[num] = 1
          return


for num in range(T):
  K = int(input())
  search(K, tri, num)
  
  

print("\n".join(map(str, answer)))
  