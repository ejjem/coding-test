import sys
input = sys.stdin.readline

N = int(input())
count = 0

cols = set()          # 같은 열에 있는지 검사
diag_left = set()     # ↙ 방향 대각선 (row - col)
diag_right = set()    # ↘ 방향 대각선 (row + col)

def solve(row):
    global count
    if row == N:
        count += 1
        return

    for col in range(N):
        if col in cols or (row - col) in diag_left or (row + col) in diag_right:
            continue
            
        cols.add(col)
        diag_left.add(row - col)
        diag_right.add(row + col)

        solve(row + 1)

        cols.remove(col)
        diag_left.remove(row - col)
        diag_right.remove(row + col)

solve(0)
print(count)