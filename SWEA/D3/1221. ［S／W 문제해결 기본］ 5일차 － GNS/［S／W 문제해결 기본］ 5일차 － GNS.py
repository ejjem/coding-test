T = int(input())
num = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
for tc in range(1, T+1):
    testcase, N = input().split()
    number = list(input().split())
    real_number = []
    answer = []
    for string in number:
        real_number.append(num.index(string))
    real_number.sort()
    for a in real_number:
        answer.append(num[a])
    print(f"#{tc}")
    print(' '.join(answer))