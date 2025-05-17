T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    board = [[' '] * N for _ in range(N)]
    # 초반 세팅
    board[N//2-1][N//2-1] = 'W'
    board[N//2][N//2] = 'W'
    board[N//2-1][N//2] = 'B'
    board[N//2][N//2-1] = 'B'
    dist = [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1)]
    for _ in range(M):
        X, Y, player = map(int, input().split())
        x, y = X-1, Y-1
        # 놓을 때는 board[Y-1][X-1] -> board[y][x]
        if player == 1: # 흑돌
            board[y][x] = 'B'
            """
            print("돌 놓기")
            for row in board:
                print(row)
            """
            for dY, dX in dist:
                dx, dy = x + dX, y + dY
                if 0 <= dx < N and 0 <= dy < N and board[dy][dx] == 'W':
                    dxx, dyy = dx + dX, dy + dY
                    tmp = [(dy, dx)]
                    while 0 <= dxx < N and 0 <= dyy < N:
                        if board[dyy][dxx] == 'B':
                            for flip_y, flip_x in tmp:
                                board[flip_y][flip_x] = 'B'
                            break
                        elif board[dyy][dxx] == 'W':
                            tmp.append((dyy, dxx))
                            dxx, dyy = dxx + dX, dyy + dY
                            continue
                        elif board[dyy][dxx] == ' ':
                            break

            """
            print("검사 후:")
            for row in board:
                print(row)
            """

        else:   # 백돌
            board[y][x] = 'W'
            """
            print("돌 놓기:")
            for row in board:
                print(row)
            """
            for dY, dX in dist:
                dx, dy = x + dX, y + dY
                if 0 <= dx < N and 0 <= dy < N and board[dy][dx] == 'B':
                    dxx, dyy = dx + dX, dy + dY
                    tmp = [(dy, dx)]
                    while 0 <= dxx < N and 0 <= dyy < N:
                        if board[dyy][dxx] == 'W':
                            for flip_y, flip_x in tmp:
                                board[flip_y][flip_x] = 'W'
                            break
                        elif board[dyy][dxx] == 'B':
                            tmp.append((dyy, dxx))
                            dxx, dyy = dxx + dX, dyy + dY
                            continue
                        elif board[dyy][dxx] == ' ':
                            break
            """
            print("검사 후:")
            for row in board:
                print(row)
            """
    count_B, count_W = 0, 0
    for i in range(N):
        for j in range(N):
            if board[i][j] == 'B':
                count_B += 1
            elif board[i][j] == 'W':
                count_W += 1
    print(f"#{tc} {count_B} {count_W}")