N = int(input())
answer = []
for i in range(1, N+1):
  number = str(i)
  if "3" in number or "6" in number or "9" in number:
   tmp = number.count("3") + number.count("6") + number.count("9")
   tmp_list = ["-"] * tmp
   answer.append("".join(tmp_list))
  else:
    answer.append(f"{i}")
print(" ".join(answer))