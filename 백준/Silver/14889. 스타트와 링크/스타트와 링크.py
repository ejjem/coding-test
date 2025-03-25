import sys
from itertools import combinations
input = sys.stdin.readline

N = int(input())
member = [x for x in range(N)]
point = [[x for x in map(int, input().split())] for _ in range(N)]
minimum = float("inf")
comb = [arr for arr in combinations(member, N//2)]  
  
team_start= comb[:len(comb)//2]
team_link = comb[len(comb)//2: ]
team_link.reverse()

for i in range(len(team_start)):
  team_start_point = 0
  team_link_point = 0
  team_start_target = team_start[i]
  team_link_target = team_link[i]
  for x, y in combinations(team_start_target, 2):
    team_start_point += point[x][y] + point[y][x]
  for x, y in combinations(team_link_target, 2):
    team_link_point += point[x][y] + point[y][x]
  
  minimum = min(minimum, abs(team_start_point - team_link_point))
  if minimum == 0:
    break

print(minimum)
  
    

  




