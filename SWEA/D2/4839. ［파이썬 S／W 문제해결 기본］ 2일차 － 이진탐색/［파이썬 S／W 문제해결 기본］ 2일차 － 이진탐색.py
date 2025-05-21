#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for tc in range(1, T+1):
    P, Pa, Pb = map(int, input().split())
    la, lb = 1, 1
    ra, rb = P, P
    count_a, count_b = 1, 1
    flag_A, flag_B = True, True
    while flag_A or flag_B:
        ca = (la + ra) // 2
        if ca > Pa:
            ra = ca
        elif ca < Pa:
            la = ca
        else:
            flag_A = False

        cb = (lb + rb) // 2
        if cb > Pb:
            rb = cb
        elif cb < Pb:
            lb = cb
        else:
            flag_B = False
        if flag_A:
            count_a += 1
        if flag_B:
            count_b += 1

    if count_a < count_b:
        print(f"#{tc} A")
    elif count_a > count_b:
        print(f"#{tc} B")
    else:
        print(f"#{tc} 0")