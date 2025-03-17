import sys
input = sys.stdin.readline

list_a, list_b = list(range(1, 11)), list(range(1, 11))
lose = 0
total = 18 * 17 / 2
A, B = map(int, input().split())

if A == B: # 땡
  list_a.remove(A)
  list_b.remove(B)
  for i in list_a:
    for j in list_b:
      if i == j and i > A: # 땡한테 진 상황
        lose += 1
      else: # 이긴 상황
        continue
        
  answer = (total - lose) / total
  print(f"{answer:.3f}")

else : # 끗
  list_a.remove(A)
  list_a.remove(B)
  index = (A + B) % 10 # 끗 계산
  
  for i in list_a:
    for j in list_b:
      if i == j: # 땡한테 진 상황
        lose += 1 #어차피 여기선 8
      else:
        tmp = (i + j) % 10 # 상대 끗 계산
        if index > tmp: #이긴 상황
          continue
        else: # 진 or 비긴 상황
          lose += 1
          
  for i in range(len(list_a)):
    for j in range(i +1, len(list_a)):
      tmp = (list_a[i] + list_a[j]) % 10 # 상대 끗 계산
      if index > tmp: #이긴 상황
        continue
      else: # 진 or 비긴 상황
        lose += 1
        
  for i in range(len(list_b)):
    for j in range(i +1, len(list_b)):
      tmp = (list_b[i] + list_b[j]) % 10 # 상대 끗 계산
      if index > tmp: #이긴 상황
        continue
      else: # 진 or 비긴 상황
        lose += 1
      
  answer = (total - lose) / total
  print(f"{answer:.3f}")


    
