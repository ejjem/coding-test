import sys
input = sys.stdin.readline

T = int(input())
answer = []

def search(bat, M, N):
  global answer
  checked = set()
  count = 0
  for X in range(M):
    for Y in range(N):
      if bat[Y][X] == 1 and (X, Y) not in checked:
        tmp = set()
        DFS(X, Y, checked)
        count += 1
  answer.append(count)      
          
def DFS(X, Y, checked):
  global M, N, bat
  stack = [(X, Y)]
  while stack:
    target_X, target_Y = stack.pop()
    if (target_X, target_Y) not in checked:
      checked.add((target_X, target_Y))
      tmp = set()
      if 0 <= target_X+1  and target_X+1 <= (M-1):
        if bat[target_Y][target_X+1] == 1 and (target_X+1, target_Y) not in checked:
          tmp.add((target_X+1, target_Y))
      if 0 <= target_X-1  and target_X-1 <= (M-1):
        if bat[target_Y][target_X-1] == 1 and (target_X-1, target_Y) not in checked:
          tmp.add((target_X-1, target_Y))
      if 0 <= target_Y+1  and target_Y+1 <= (N-1):
        if bat[target_Y+1][target_X] == 1 and (target_X, target_Y+1) not in checked:
          tmp.add((target_X, target_Y+1))
      if 0 <= target_Y-1  and target_Y-1 <= (N-1):
        if bat[target_Y-1][target_X] == 1 and (target_X, target_Y-1) not in checked:
          tmp.add((target_X, target_Y-1))
      for node in tmp:
        stack.append(node)
        
  

for i in range(T):
  M, N, K = map(int, input().split())
  bat = []
  bat = [[0]*M for _ in range(N)]  
  for _ in range(K):
    X, Y = map(int, input().split())
    bat[Y][X] = 1
  search(bat, M, N)
  
for i in answer:
  print(i)
    
  