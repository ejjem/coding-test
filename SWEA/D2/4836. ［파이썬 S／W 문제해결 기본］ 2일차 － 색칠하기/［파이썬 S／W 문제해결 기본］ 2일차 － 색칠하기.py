#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    data = [list(map(int, input().split())) for _ in range(N)]
    board = [[0]*10 for _ in range(10)]
    red = []
    blue = []
    count = 0
    for row in data:
        if row[-1] == 1:
            red.append(row)
        elif row[-1] == 2:
            blue.append(row)
    for row in red:
        start_x, start_y, end_x, end_y, color = row
        for i in range(start_y, end_y+1):
            for j in range(start_x, end_x+1):
                board[i][j] = 1
    for row in blue:
        start_x, start_y, end_x, end_y, color = row
        for i in range(start_y, end_y+1):
            for j in range(start_x, end_x+1):
                if board[i][j] == 1:
                    count += 1
    print(f"#{tc} {count}")