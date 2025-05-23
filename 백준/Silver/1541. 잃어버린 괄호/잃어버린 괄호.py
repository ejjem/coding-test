import sys
input = sys.stdin.readline

origin = list(input().rstrip())
i = 0
string = []
number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}

# 1. 파싱 단계: 숫자와 연산자 분리
while i < len(origin):
    if origin[i] in number:
        tmp = ''
        while i < len(origin) and origin[i] in number:
            tmp += origin[i]
            i += 1
        string.append(tmp)
    else:
        string.append(origin[i])
        i += 1

# 2. 계산 단계: 그리디 적용
answer = int(string[0])  # 첫 숫자부터 시작
i = 1
minus_mode = False

while i < len(string):
    if string[i] == '+':
        i += 1
        num = int(string[i])
        if minus_mode:
            answer -= num
        else:
            answer += num
    elif string[i] == '-':
        i += 1
        num = int(string[i])
        answer -= num
        minus_mode = True  # 이후부터는 전부 빼기
    i += 1

print(answer)
