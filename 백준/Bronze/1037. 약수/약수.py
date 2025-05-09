import sys
input = sys.stdin.readline
num = int(input())
arr = list(map(int, input().split()))
print(max(arr) * min(arr))