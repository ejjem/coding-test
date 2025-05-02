T = int(input())
for tc in range(1, T+1):
  student = []
  N, K = map(int, input().split())
  students = []
  for i in range(N):
    a, b, c = map(int, input().split())
    score = (a*35)/100 + (b*45)/100 + (c*20)/100
    student.append((i+1, score))
  student.sort(key=lambda x: x[1])
  for i in range(N):
    idx, score = student[i]
    if idx == K:
      if 0 <= i <= N//10-1:
        print(f"#{tc} D0")
      elif N//10 <= i <= 2*N//10-1:
        print(f"#{tc} C-")
      elif 2*N//10 <= i <= 3*N//10-1:
        print(f"#{tc} C0")
      elif 3*N//10 <= i <= 4*N//10-1:
        print(f"#{tc} C+")
      elif 4*N//10 <= i <= 5*N//10-1:
        print(f"#{tc} B-")
      elif 5*N//10 <= i <= 6*N//10-1:
        print(f"#{tc} B0")
      elif 6*N//10 <= i <= 7*N//10-1:
        print(f"#{tc} B+")
      elif 7*N//10 <= i <= 8*N//10-1:
        print(f"#{tc} A-")
      elif 8*N//10 <= i <= 9*N//10-1:
        print(f"#{tc} A0")
      elif 9*N//10 <= i <= 10*N//10-1:
        print(f"#{tc} A+")