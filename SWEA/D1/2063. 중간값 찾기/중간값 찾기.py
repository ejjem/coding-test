N = int(input())
number = list(map(int, input().split()))
number.sort()
print(number[N//2])