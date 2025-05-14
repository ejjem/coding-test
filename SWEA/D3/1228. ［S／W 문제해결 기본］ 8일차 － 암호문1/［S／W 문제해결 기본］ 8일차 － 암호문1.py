for tc in range(1, 11):
    N = int(input())
    origin = list(map(int, input().split()))
    num_of_inst = int(input())
    origin_inst = list(input().split())
    index = []
    insts = []
    tmp = []
    answer = []
    for i in range(len(origin)):
        answer.append(origin[i])
    for i in range(len(origin_inst)):
        if origin_inst[i] == 'I':
            index.append(i)
    index.append(len(origin_inst))
    for i in range(1, len(index)):
        insts.append(origin_inst[index[i-1]+1:index[i]])
    for inst in insts:
        tmp = []
        x = int(inst[0])
        y = int(inst[1])
        s = list(map(int, inst[2:]))
        tmp.extend(answer[:x])
        tmp.extend(s)
        tmp.extend(answer[x:])
        answer = []
        for i in range(len(tmp)):
            answer.append(tmp[i])
    print(f"#{tc} {' '.join(map(str, answer[:10]))}")
