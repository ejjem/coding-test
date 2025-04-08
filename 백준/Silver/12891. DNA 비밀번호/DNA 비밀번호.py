import sys
input = sys.stdin.readline
S, P = map(int, input().split())
string = list(input().rstrip())
checklist = list(map(int, input().split()))
window = [0] * 4
count = 0

def check(list, index):
  if list[index] == "A":
    return 0
  elif list[index] == "C":
    return 1
  elif list[index] == "G":
    return 2
  elif list[index] == "T":
    return 3

for i in range(P):
  window[check(string, i)] += 1
    
def count_check(list1, list2):
  if all(a >= b for a, b in zip(list1, list2)):
    return 1
  return 0

count += count_check(window, checklist)

for i in range(P, S):
  window[check(string, i-P)] -= 1
  window[check(string, i)] += 1
  count += count_check(window, checklist)
    
print(count)