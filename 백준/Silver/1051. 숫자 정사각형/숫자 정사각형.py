import sys
input = sys.stdin.readline

N, M = map(int, input().split())
data = [list(map(int, input().rstrip())) for _ in range(N)]

max_length = min(N, M)
max_gap = max_length - 1
answer = 1
for gap in range(1 , max_gap + 1): # gap: 0 ~ max_gap
    #print(f"gap: {gap}")
    row, col = 0, 0
    
    for row in range(N - gap): # row: 0 ~ N - gap - 1
        for col in range(M - gap): # col: 0 ~ M - gap - 1
         tmp = data[row][col] #왼쪽 상단 꼭짓점
         #print(f"tmp: {tmp}")
         #print(f"gap: {gap}")
         #print(f"col: {col}")
         #print(f"row: {row}")
         
         if data[row][col + gap] == tmp and data[row + gap][col] == tmp and data[row + gap][col + gap] == tmp:
             answer = max(answer, gap + 1)
             #print(f"answer: {answer}")
                         
print(answer ** 2)
