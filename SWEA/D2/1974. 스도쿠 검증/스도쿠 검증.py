T = int(input())
for tc in range(1, T+1):
  puzzle = []
  for _ in range(9):
    tmp = list(map(int, input().split()))
    puzzle.append(tmp)
  # 가로 검사
  def search(puzzle):
    for row in puzzle:
      check = set()
      for number in row:
        check.add(number)
      if len(check) != 9:
        return 0
    for i in range(9):
      check = set()
      for j in range(9):
        check.add(puzzle[j][i])
      if len(check) != 9:
        return 0
    for gap in range(0, 7, 3):
      for gap_2 in range(0, 7, 3):
        check = set()
        for i in range(gap, gap+3):
          for j in range(gap_2, gap_2+3):
            check.add(puzzle[i][j])
        if len(check) != 9:
          return 0
    return 1
  print(f"#{tc} {search(puzzle)}")