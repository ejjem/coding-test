import sys
input = sys.stdin.readline
i = 0
N = int(input())
A = set(input().split())
M = int(input())
M_1 = input().split()

while(i < M):
    if M_1[i] in A:
        print(1)
    else:
        print(0)
    i += 1