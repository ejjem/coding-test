T = int(input())
for tc in range(1, T+1):
  N = int(input())
  points = [x for x in map(int, input().split())]
  possible = set()
  possible.add(0)
  for point in points:
    tmp = set()
    for p in possible:
      tmp.add(p + point)
    possible.update(tmp)
  print(f"#{tc} {len(possible)}")