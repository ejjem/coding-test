import sys
input = sys.stdin.readline
N = int(input())
word = set()
for _ in range(N):
    word.add(input().rstrip())
arr = sorted(word, key=lambda x: (len(x), x))
print("\n".join(arr))