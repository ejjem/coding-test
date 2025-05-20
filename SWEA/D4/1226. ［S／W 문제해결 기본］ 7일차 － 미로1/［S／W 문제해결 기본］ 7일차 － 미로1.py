for _ in range(10):
    tc = int(input())
    maze = []
    start_x, start_y, end_x, end_y = 0, 0, 0, 0
    for i in range(16):
        tmp = list(map(int, list(input().rstrip())))
        maze.append(tmp)
        if 2 in tmp:
            start_x = tmp.index(2)
            start_y = i
        if 3 in tmp:
            end_x = tmp.index(3)
            end_y = i
    dist = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    stack = [(start_y, start_x)]
    visited = set()
    flag = False
    while stack:
        y, x = stack.pop()
        visited.add((y, x))
        for Y, X in dist:
            dy, dx = y + Y, x + X
            if 0 <= dx <= 15 and 0 <= dy <= 15:
                if maze[dy][dx] == 3:
                    flag = True
                    break
                if maze[dy][dx] == 0 and (dy, dx) not in visited:
                    stack.append((dy, dx))
        if flag:
            break
    if flag:
        print(f"#{tc} 1")
    else:
        print(f"#{tc} 0")