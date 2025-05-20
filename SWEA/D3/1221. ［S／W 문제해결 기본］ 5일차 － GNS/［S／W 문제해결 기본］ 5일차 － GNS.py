T = int(input())
num = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
for tc in range(1, T+1):
    testcase, N = input().split()
    number = list(input().split())
    count = [0] * 10
    answer = []
    for string in number:
        count[num.index(string)] += 1
    for i in range(10):
        tmp = [num[i]] * count[i]
        answer.extend(tmp)
    print(f"#{tc}")
    print(' '.join(answer))