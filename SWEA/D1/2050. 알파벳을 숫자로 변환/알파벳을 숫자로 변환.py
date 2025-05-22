arr = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
string = list(input().rstrip())
answer = []
for alphabet in string:
    tmp = str(arr.index(alphabet) + 1)
    answer.append(tmp)
print(' '.join(answer))