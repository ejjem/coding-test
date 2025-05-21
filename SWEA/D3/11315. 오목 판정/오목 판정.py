#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    N = int(input())
    board = [list(input().rstrip()) for _ in range(N)]

    def search(N, board):
        for row in board:
            for i in range(N - 4):
                if all(doll == 'o' for doll in row[i:i+5]):
                    print(f"#{tc} YES")
                    return

        for col in range(N):
            for row in range(N - 4):
                target = []
                for i in range(5):
                    target.append(board[row + i][col])
                if all(doll == 'o' for doll in target):
                    print(f"#{tc} YES")
                    return

        for i in range(N):
            for j in range(N):
                target_1 = []
                target_2 = []
                if (i + j) < N:
                    for k in range(5):
                        if (i + j + k) < N:
                            target_1.append(board[j + k][i + j + k])
                            target_2.append(board[i + j + k][j + k])
                if all(doll == 'o' for doll in target_1) and len(target_1) == 5:
                    print(f"#{tc} YES")
                    return
                if all(doll == 'o' for doll in target_2) and len(target_2) == 5:
                    print(f"#{tc} YES")
                    return

        for i in range(N):
            for j in range(N):
                target_1 = []
                target_2 = []
                if (i + j) < N and (N - 1 - i - j) >= 0:
                    for k in range(5):
                        if (i + j + k) < N and (N - 1 - i - j - k) >= 0:
                            target_1.append(board[j + k][N - 1 - i - j - k])
                            target_2.append(board[i + j + k][N - 1 - j - k])
                if all(doll == 'o' for doll in target_1) and len(target_1) == 5:
                    print(f"#{tc} YES")
                    return
                if all(doll == 'o' for doll in target_2) and len(target_2) == 5:
                    print(f"#{tc} YES")
                    return

        print(f"#{tc} NO")

    search(N, board)
