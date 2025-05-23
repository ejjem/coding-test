dists = [(-1, -1), (-1, 0), (-1, 1),
         ( 0, -1),          ( 0, 1),
         ( 1, -1), ( 1, 0), ( 1, 1)]

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    board = [list(map(int, input().split())) for _ in range(h)]
    visited = set()
    count = 0

    def DFS(a, b):
        global visited
        stack = [[a, b]]
        visited.add((a, b))
        while stack:
            y, x = stack.pop()
            for dy, dx in dists:
                if 0 <= y + dy < h and 0 <= x + dx < w:
                    if board[y+dy][x+dx] == 1 and (y+dy, x+dx) not in visited:
                            visited.add((y+dy, x+dx))
                            stack.append((y+dy, x+dx))
    for i in range(h):
        for j in range(w):
            if board[i][j] == 1 and (i, j) not in visited:
                DFS(i, j)
                count += 1
    print(count)