T = int(input())
answer = []
for ts in range(1, T+1):
  number = list(map(int, input().split()))
  avg = sum(number) / 10
  avg_round = round(avg)
  if avg_round < avg and avg - avg_round == 0.5:
    avg_round += 1
  answer.append(f"#{ts} {avg_round}")

print("\n".join(answer))