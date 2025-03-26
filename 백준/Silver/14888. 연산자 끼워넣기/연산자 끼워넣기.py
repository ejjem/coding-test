import sys
input = sys.stdin.readline

N = int(input())
number = [x for x in map(int, input().split())]
add, sub, mul, div = map(int, input().split())

maximum = -float("inf")
minimum = float("inf")

def search(add, sub, mul, div, tmp, i):
  global number
  global maximum
  global minimum
  if i == N:
    maximum = max(maximum, tmp)
    minimum = min(minimum, tmp)
    return
  if add > 0:
    search( (add - 1), sub, mul, div, tmp + number[i], (i+1) )
  if sub > 0:
    search( add, (sub - 1), mul, div, tmp - number[i], (i+1) )
  if mul > 0:
    search( add, sub, (mul - 1), div, tmp * number[i], (i+1) )
  if div > 0:
    if tmp >= 0:
      search( add, sub, mul, (div - 1), tmp // number[i], (i+1) )
    else:
      search( add, sub, mul, (div - 1) , - (abs(tmp) // number[i]), (i+1))

search(add, sub, mul, div, number[0], 1)
print(maximum)
print(minimum)
