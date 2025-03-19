import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

answer = float('inf')

for row_start in range(N - 7):  # 8x8 크기의 체스판을 탐색
    for col_start in range(M - 7):
        cnt1, cnt2 = 0, 0  # 첫 칸을 'W'로 시작하는 경우(cnt1), 'B'로 시작하는 경우(cnt2)

        for i in range(8):
            for j in range(8):
                if (i + j) % 2 == 0:  # 짝수 위치
                    if board[row_start + i][col_start + j] != 'W':
                        cnt1 += 1
                    if board[row_start + i][col_start + j] != 'B':
                        cnt2 += 1
                else:  # 홀수 위치
                    if board[row_start + i][col_start + j] != 'B':
                        cnt1 += 1
                    if board[row_start + i][col_start + j] != 'W':
                        cnt2 += 1
        
        answer = min(answer, cnt1, cnt2)

print(answer)