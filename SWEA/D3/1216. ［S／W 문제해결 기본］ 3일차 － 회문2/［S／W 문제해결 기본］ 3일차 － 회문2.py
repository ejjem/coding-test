for _ in range(10):
    tc = int(input())
    board = [list(input()) for _ in range(100)]
    maximum = 1
    # 가로
    for row in board:
        for i in range(100, 1, -1):
            for j in range(101-i):
                tmp = row[j:j+i]
                if tmp == tmp[::-1]:
                    maximum = max(maximum, i)
                    break
            else:
                continue
            break
    # 세로
    for a in range(100):
        col = []
        for b in range(100):
            col.append(board[b][a])

        for i in range(100, 1, -1):
            for j in range(101-i):
                tmp = col[j:j+i]
                if tmp == tmp[::-1]:
                    maximum = max(maximum, i)
                    break
            else:
                continue
            break
    print(f"#{tc} {maximum}")