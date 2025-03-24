import sys
input = sys.stdin.readline

N = int(input())  
schedule = [tuple(x for x in map(int, input().split())) for _ in range(N)]
maximum = 0

def search(day, cnt):
  global maximum
  if day >= N:
    maximum = max(maximum, cnt)
    return
  
  search(day + 1, cnt)
  
  need_day, pay = schedule[day]
  cnt += pay
  if need_day + day <= N:
    search(need_day + day, cnt)
  
search(0, 0)
print(maximum)
