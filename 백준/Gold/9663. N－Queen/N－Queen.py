import sys
input = sys.stdin.readline
N = int(input())
arr = [-1] * N
count = 0
def check(row):
    global arr
    for i in range(row):
        if arr[i] == arr[row] or (row - i) == abs(arr[row]-arr[i]):
            return False
    return True

def solve(row):
    global count, N, arr
    if row == N:
        count += 1
        return
    for i in range(N):
        arr[row] = i
        if check(row):
            solve(row+1)
solve(0)
print(count)