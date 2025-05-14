import sys
input = sys.stdin.readline

T = int(input())
for tc in range(T):
    arr = list(input())
    def checking(arr):
        check = []
        for i in range(len(arr)):
            if arr[i] == '(':
                check.append('(')
            if arr[i] == ')':
                if len(check) == 0:
                    print('NO')
                    return
                tmp = check.pop()
                if tmp != '(':
                    print('NO')
                    return
        if check:
            print('NO')
        else:
            print('YES')
    checking(arr)