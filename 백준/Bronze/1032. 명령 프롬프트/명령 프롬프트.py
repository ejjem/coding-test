import sys
input = sys.stdin.readline

N = int(input())
file = [input().strip() for _ in range(N)]

answer = []
for i in range(len(file[0])): 
    tmp = file[0][i]
    if all(file[j][i] == tmp for j in range(1, N)):  # all() 사용
        answer.append(tmp)
    else:
        answer.append("?")

print("".join(answer))