from collections import defaultdict
T = int(input())
for tc in range(1, T+1):
    graph = defaultdict(list)
    N, M = map(int, input().split())
    maximum = -float('inf')
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    def DFS(node):
        global graph
        global maximum
        stack = [(node, {node})]
        while stack:
            now, visited = stack.pop()
            flag = False
            for neighbor in graph[now]:
                if neighbor not in visited:
                    flag = True
                    new_visited = visited.copy()
                    new_visited.add(neighbor)
                    stack.append((neighbor, new_visited))
            if not flag:
                maximum = max(maximum, len(visited))
                if len(visited) == N:
                    break
    for i in range(1, N+1):
        DFS(i)
    print(f"#{tc} {maximum}")