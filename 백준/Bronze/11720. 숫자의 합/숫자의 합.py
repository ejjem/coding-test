import sys
input = sys.stdin.readline
N = int(input())
number = list(map(int, input().rstrip()))
print(sum(number))