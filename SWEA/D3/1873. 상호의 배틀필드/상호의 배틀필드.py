T = int(input())
for tc in range(1, T+1):
    H, W = map(int, input().split())
    board = []
    tank_x = 0
    tank_y = 0
    for i in range(H):
        tmp = list(input().rstrip())
        for tank in ['<', '>', '^', 'v']:
            if tank in tmp:
                tank_x = tmp.index(tank)
                tank_y = i
        board.append(tmp)
    N = int(input())
    inst = list(input().rstrip())
    for i in range(N):
        if inst[i] == 'S':
            if board[tank_y][tank_x] == '^':
                if tank_y - 1 >= 0:
                    for j in range(tank_y-1, -1, -1):
                        if board[j][tank_x] == '#':
                            break
                        if board[j][tank_x] == '*':
                            board[j][tank_x] = '.'
                            break
            elif board[tank_y][tank_x] == 'v':
                if tank_y + 1 < H:
                    for j in range(tank_y+1, H):
                        if board[j][tank_x] == '#':
                            break
                        if board[j][tank_x] == '*':
                            board[j][tank_x] = '.'
                            break
            elif board[tank_y][tank_x] == '<':
                if tank_x - 1 >= 0:
                    for j in range(tank_x-1, -1, -1):
                        if board[tank_y][j] == '#':
                            break
                        if board[tank_y][j] == '*':
                            board[tank_y][j] = '.'
                            break
            elif board[tank_y][tank_x] == '>':
                if tank_x + 1 < W:
                    for j in range(tank_x+1, W):
                        if board[tank_y][j] == '#':
                            break
                        if board[tank_y][j] == '*':
                            board[tank_y][j] = '.'
                            break
        elif inst[i] == 'U':
            board[tank_y][tank_x] = '^'
            if tank_y - 1 >= 0 and board[tank_y-1][tank_x] == '.':
                board[tank_y][tank_x] = '.'
                tank_y -= 1
                board[tank_y][tank_x] = '^'
        elif inst[i] == 'D':
            board[tank_y][tank_x] = 'v'
            if tank_y + 1 < H and board[tank_y+1][tank_x] == '.':
                board[tank_y][tank_x] = '.'
                tank_y += 1
                board[tank_y][tank_x] = 'v'
        elif inst[i] == 'L':
            board[tank_y][tank_x] = '<'
            if tank_x - 1 >= 0 and board[tank_y][tank_x-1] == '.':
                board[tank_y][tank_x] = '.'
                tank_x -= 1
                board[tank_y][tank_x] = '<'
        elif inst[i] == 'R':
            board[tank_y][tank_x] = '>'
            if tank_x + 1 < W and board[tank_y][tank_x+1] == '.':
                board[tank_y][tank_x] = '.'
                tank_x += 1
                board[tank_y][tank_x] = '>'
    print(f"#{tc} {''.join(board[0])}")
    for i in range(1, H):
        print(''.join(board[i]))