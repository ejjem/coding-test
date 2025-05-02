T = int(input())
grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    student = []
    for i in range(N):
        a, b, c = map(int, input().split())
        score = a * 0.35 + b * 0.45 + c * 0.2
        student.append((i + 1, score))
    student.sort(key=lambda x: x[1], reverse=True)
    for i in range(N):
        if student[i][0] == K:
            rank = i
            break
    group_size = N // 10
    grade_index = rank // group_size
    print(f"#{tc} {grades[grade_index]}")