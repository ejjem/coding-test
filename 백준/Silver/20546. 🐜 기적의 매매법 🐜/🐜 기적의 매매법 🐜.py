import sys
input = sys.stdin.readline

money = int(input())
J_money = S_money = money # J_money: 준현이 돈, S_money: 성민이 돈
J_asset, S_asset = 0, 0
up, down = 0, 0
price = list(map(int, input().split()))
# price = [int(x) for x in input.split()]
past = price[0]
check = [past]
for i in range(len(price)):
  today_price = price[i]
  #print(f"날짜: 1월 {i + 1}일")
  #print(f"today_price: {today_price}")
  # 준현 계산
  if today_price <= J_money:
    # print("준현 구매")
    count_1 = J_money // today_price
    J_money -= today_price * count_1
    J_asset += count_1
    # print(f"준현 남은 돈: {J_money}, 준현 자산: {J_asset}")
  
  # 성민 계산
  #print("성민 파트 계산 시작")
  #print(check)
  #if today_price == past: # 가격 같으면 현상 유지
    #print("가격 변동 없음")
  #elif today_price > past:
  if today_price > past: # 가격 상승
    if up: # 2일 연속 가격 상승중
      #print("가격 상승 진행중")
      check.append(today_price)
    else: # 첫 가격 상승
      #print("가격 상승 시작")
      check.clear()
      check.append(past)
      check.append(today_price)
      up = 1
      down = 0
  elif today_price < past: # 가격 하락
    if down: # 2일 연속 가격 하락중
      #print("가격 하락 진행중")
      check.append(today_price)
    else: # 첫 가격 하락
      #print("가격 하락 시작")
      check.clear()
      check.append(past)
      check.append(today_price)
      up = 0
      down = 1
  #print(f"변화 반영: {check}")
  if len(check) >= 4:
    if up:
      #print("성민 전량 매도")
      S_money += S_asset * today_price
      S_asset = 0
      #print(f"성민 남은 돈: {S_money}, 자산: {S_asset}")
      
    elif down and today_price <= S_money:
      #print("성민 전량 매수")
      count_2 = S_money // today_price
      S_money -= count_2 * today_price
      S_asset += count_2
      #print(f"성민 남은 돈: {S_money}, 자산: {S_asset}")
  
  #print("-----------")
  past = price[i]
  
final_price = price[13]
J_final = J_money + J_asset * final_price
S_final = S_money + S_asset * final_price
#print(f"준현 최종: {J_final}, 성민 최종: {S_final}")

if J_final == S_final:
  print("SAMESAME")
elif J_final > S_final:
  print("BNP")
else: 
  print("TIMING")    
    
  

  