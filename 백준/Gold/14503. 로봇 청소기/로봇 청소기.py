import sys
input = sys.stdin.readline

N, M = map(int, input().split())
y, x, d = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
dist = [(-1, 0), (0, 1), (1, 0), (0, -1)] # 방향 전환할때는 거꾸로
dy, dx = dist[d]
count = 0
flag = False
while True:
    if board[y][x] == 0: # 제자리 청소
        #print(f"({y}, {x}) 제자리 청소, 방향: {d}")
        board[y][x] = 2
        count += 1
        continue
    else:
        #print("청소 불가")
        flag = False
        # 제자리 청소 불가
        # 현재 칸의 주변 4칸 중 청소할 곳 탐색
        for dyy, dxx in dist:
            if 0 <= y + dyy < N and 0 <= x + dxx < M and board[y+dyy][x+dxx] == 0:
                flag = True
        if flag:
            while True:
                if d == 0:
                    d = 3
                else:
                    d -= 1
                dy, dx = dist[d]
                if 0 <= y + dy < N and 0 <= x + dx < M and board[y + dy][x + dx] == 0:
                    x, y = x + dx, y + dy
                    break
            #print("청소 가능 구역 찾음")
            #print(f"({dy}, {dx}) 방향(d: {d})으로 이동")
            #print(f"({y}, {x})로 이동")
            continue
        else:
            #print("청소 가능 구역 없음")
            if 0 <= x - dx < M and 0 <= y - dy < N and board[y - dy][x - dx] != 1:
                x, y = x - dx, y - dy
                #print(f"후진 가능, 방향(d: {d})를 보며 후진, ({y}, {x})로 이동")
                continue
            else:
                #print("후진 불가, 프로세스 종료")
                break
print(count)