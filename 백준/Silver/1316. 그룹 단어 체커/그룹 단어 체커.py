import sys
input = sys.stdin.readline
N = int(input())
count = 0
for _ in range(N):
    word = list(input().rstrip())
    check = set()
    for i in range(1, len(word)):
        if word[i] in check:
            break
        if word[i] != word[i-1]:
            check.add(word[i-1])
    else:
        count += 1
print(count)