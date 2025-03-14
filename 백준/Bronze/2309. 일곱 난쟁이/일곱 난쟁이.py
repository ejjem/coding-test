import sys
input = sys.stdin.readline

data = [int(input()) for _ in range(9)]
def print_answer(answers):
  for answer in answers:
    print(answer)
    
data_sum = sum(data)

def start():
  for i in range(8):
    for j in range(i + 1, 9):
      tmp1 = data[i]
      tmp2 = data[j]
      tmp = tmp1 + tmp2
      if data_sum - tmp == 100:
        data.remove(tmp1)
        data.remove(tmp2)
        data.sort()
        print_answer(data)
        return

start()

        




