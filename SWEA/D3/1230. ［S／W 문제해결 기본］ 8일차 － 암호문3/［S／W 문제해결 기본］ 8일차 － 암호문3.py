for tc in range(1, 11):
    N = int(input())
    origin = list(map(int, input().split()))
    num_inst = int(input())
    inst = list(input().split())
    i = 0
    while i < len(inst):
        if inst[i] == 'I':
            x = int(inst[i+1])
            y = int(inst[i+2])
            s = list(map(int, inst[i+3:i+3+y]))
            origin[x:x] = s
            i += 3+y
        elif inst[i] == 'D':
            x = int(inst[i+1])
            y = int(inst[i+2])
            del origin[x:x+y]
            i += 3
        elif inst[i] == 'A':
            y = int(inst[i+1])
            s = list(map(int, inst[i+2:i+2+y]))
            origin.extend(s)
            i += 2+y
    print(f"#{tc} {' '.join(map(str, origin[:10]))}")
