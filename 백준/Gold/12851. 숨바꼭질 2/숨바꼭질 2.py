from collections import deque

N, K = map(int, input().split())
dist = [-1] * 100001     # 최소 시간
count = [0] * 100001      # 경우의 수
queue = deque()
queue.append(N)
dist[N] = 0
count[N] = 1

while queue:
    current = queue.popleft()
    for next_pos in (current - 1, current + 1, current * 2):
        if 0 <= next_pos < 100001:
            if dist[next_pos] == -1:
                dist[next_pos] = dist[current] + 1
                count[next_pos] = count[current]
                queue.append(next_pos)
                
            elif dist[next_pos] == dist[current] + 1:
                count[next_pos] += count[current]

print(dist[K]) 
print(count[K])