#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    R, C = map(int, input().split())
    insts = [ list(input().rstrip()) for _ in range(R)]
    memory = 0
    x, y = 0, 0
    dist_x, dist_y = 1, 0
    dist = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
    switch_dist = {'>', '<', '^', 'v'}
    count = 0
    stack = [(0, 0, 0, 0, 1)]
    visited = set()
    possible = False
    while stack:
        y, x, memory, dist_y, dist_x = stack.pop()
        #print(f"y: {y} x: {x} mem: {memory} dist_y: {dist_y} dist_x: {dist_x}")
        inst = insts[y][x]
        #print(f"{inst}")
        if inst in number:
            memory = int(inst)
        elif inst in switch_dist:
            if inst == '>':
                dist_x, dist_y = 1, 0
            elif inst == '<':
                dist_x, dist_y = -1, 0
            elif inst == '^':
                dist_x, dist_y = 0, -1
            elif inst == 'v':
                dist_x, dist_y = 0, 1
        elif inst == '_':
            if memory == 0:
                dist_x, dist_y = 1, 0
            else:
                dist_x, dist_y = -1, 0
        elif inst == '|':
            if memory == 0:
                dist_x, dist_y = 0, 1
            else:
                dist_x, dist_y = 0, -1
        elif inst == '@':
            possible = True
            print(f"#{tc} YES")
            break
        elif inst == '?':
            for dist_yy, dist_xx in dist:
                nx = (x + dist_xx) % C
                ny = (y + dist_yy) % R

                if (ny, nx, memory, dist_yy, dist_xx) not in visited:
                    visited.add((ny, nx, memory, dist_yy, dist_xx))
                    stack.append((ny, nx, memory, dist_yy, dist_xx))
            continue
        elif inst == '+':
            if memory == 15:
                memory = 0
            else:
                memory += 1
        elif inst == '-':
            if memory == 0:
                memory = 15
            else:
                memory -= 1
        x = (x + dist_x) % C
        y = (y + dist_y) % R  

        if (y, x, memory, dist_y, dist_x) not in visited:
            visited.add((y, x, memory, dist_y, dist_x))
            stack.append((y, x, memory, dist_y, dist_x))
    if not possible:
        print(f"#{tc} NO")