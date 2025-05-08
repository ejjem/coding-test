T = int(input())
def company_1(P, W):
  return P*W
def company_2(Q, R, S, W):
  tmp = W-R
  if tmp < 0:
    return Q
  else:
    return Q + tmp*S
for tc in range(1, T+1):
  # W: 사용량
  P, Q, R, S, W = map(int, input().split())
  answer = min(company_1(P, W), company_2(Q, R, S, W))
  print(f"#{tc} {answer}")