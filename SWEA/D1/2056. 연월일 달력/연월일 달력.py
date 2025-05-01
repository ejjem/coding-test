T = int(input())
days= {1:31,2:28,3:31,4:30,5:31,6:30,7:31,8:31,9:30,10:31,11:30,12:31}

for tc in range(1, T+1):
  tmp = input()
  year = tmp[0:4]
  month = tmp[4:6]
  day = tmp[6:]
  if 0 < int(month) < 13 and 1 <= int(day) <= days[int(month)]:
    print(f"#{tc} {year}/{month}/{day}")
  else:
    print(f"#{tc} -1")