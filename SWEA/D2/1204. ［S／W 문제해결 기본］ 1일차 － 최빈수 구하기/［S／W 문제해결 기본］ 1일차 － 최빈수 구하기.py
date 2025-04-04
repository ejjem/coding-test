T = int(input())
answer_list = []
for tc in range(T):
  N = int(input())
  number = [x for x in map(int, input().split())]
  number_set = set(number)
  maximum = -float("inf")
  answer = 0
  for i in number_set:
    tmp = number.count(i)
    if maximum == tmp:
      answer = max(answer, i)
    elif maximum < tmp: 
      maximum = tmp
      answer = i
  answer_list.append(f"#{N} {answer}")

print("\n".join(answer_list))