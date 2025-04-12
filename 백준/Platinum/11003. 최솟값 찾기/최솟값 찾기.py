import sys
from collections import deque
input = sys.stdin.readline

N, L = map(int, input().split())
deque = deque()
numbers = list(map(int, input().split()))

for i in range(N):
  # 큰 값들 다 털어내기
  while deque and deque[-1][0] > numbers[i]:
    deque.pop()
  # (값, 인덱스)
  deque.append((numbers[i], i))
  # 슬라이딩 윈도우 크기 맞추기
  if deque[0][1] <= i - L:
    deque.popleft()
  print(deque[0][0], end=' ')