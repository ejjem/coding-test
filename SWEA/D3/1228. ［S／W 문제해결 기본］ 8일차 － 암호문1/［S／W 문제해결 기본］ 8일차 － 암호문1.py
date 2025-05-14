for tc in range(1, 11):
    N = int(input())
    origin = list(input().split())
    num_inst = int(input())
    inst = list(input().split())
    i = 0
    while i < len(inst):
        if inst[i] == 'I':
            x = int(inst[i+1])
            y = int(inst[i+2])
            s = inst[i+3:i+3+y]
            origin[x:x] = s
            i += 3+y
        else:
            i += 1
    print(f"#{tc} {' '.join(origin[:10])}")