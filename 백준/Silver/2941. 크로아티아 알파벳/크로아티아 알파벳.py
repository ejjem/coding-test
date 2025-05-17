import sys
input = sys.stdin.readline
string = list(input().rstrip())
count = 0
alphabet = {'c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z='}
i = 0
while i < len(string):
    if string[i] == 'c':
        if i+1 < len(string):
            if string[i+1] == '=':
                count += 1
                i += 2
                continue
            elif string[i+1] == '-':
                count += 1
                i += 2
                continue
    elif string[i] == 'd':
        if i+2 < len(string):
            if string[i+1] == 'z' and string[i+2] == '=':
                count += 1
                i += 3
                continue
        if i+1 < len(string):
            if string[i+1] == '-':
                count += 1
                i += 2
                continue
    elif string[i] == 'l':
        if i+1 < len(string):
            if string[i+1] == 'j':
                count += 1
                i += 2
                continue
    elif string[i] == 'n':
        if i+1 < len(string):
            if string[i+1] == 'j':
                count += 1
                i += 2
                continue
    elif string[i] == 's':
        if i+1 < len(string):
            if string[i+1] == '=':
                count += 1
                i += 2
                continue
    elif string[i] == 'z':
        if i+1 < len(string):
            if string[i+1] == '=':
                count += 1
                i += 2
                continue
    count += 1
    i += 1
print(count)