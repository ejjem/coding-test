import sys
input = sys.stdin.readline

T = int(input())
answer = []

def search(bat, M, N):
    checked = set()
    count = 0
    for X in range(M):
        for Y in range(N):
            if bat[Y][X] == 1 and (X, Y) not in checked:
                DFS(X, Y, checked, bat, M, N)
                count += 1
    answer.append(count)      

def DFS(X, Y, checked, bat, M, N):
    stack = [(X, Y)]
    checked.add((X, Y))

    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while stack:
        x, y = stack.pop()
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            if 0 <= nx < M and 0 <= ny < N:
                if bat[ny][nx] == 1 and (nx, ny) not in checked:
                    checked.add((nx, ny))
                    stack.append((nx, ny))

for _ in range(T):
    M, N, K = map(int, input().split())
    bat = [[0] * M for _ in range(N)]  
    for _ in range(K):
        X, Y = map(int, input().split())
        bat[Y][X] = 1
    search(bat, M, N)

for i in answer:
    print(i)