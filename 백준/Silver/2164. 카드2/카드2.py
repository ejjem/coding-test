from collections import deque
import sys
input = sys.stdin.readline
N = int(input())
card = deque(list(range(1, N + 1, 1)))

while(len(card) != 1):
    card.popleft()
    card.append(card.popleft())

print(card[0])