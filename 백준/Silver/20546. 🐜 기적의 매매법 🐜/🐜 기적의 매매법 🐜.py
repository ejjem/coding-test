import sys
input = sys.stdin.readline

money = int(input())
J_money = S_money = money # J_money: 준현이 돈, S_money: 성민이 돈
J_asset, S_asset = 0, 0
up, down = 0, 0
price = list(map(int, input().split()))
past = price[0]
for i in range(len(price)):
  today_price = price[i]
  # 준현 계산
  if today_price <= J_money:
    count_1 = J_money // today_price
    J_money -= today_price * count_1
    J_asset += count_1
  
  # 성민 계산
  if today_price == past:
    up = 0
    down = 0
  elif today_price > past: # 가격 상승
    down = 0
    up += 1
  elif today_price < past: # 가격 하락
    up = 0
    down += 1
        
  if up >= 3:
    S_money += S_asset * today_price
    S_asset = 0
  elif down >= 3 and today_price <= S_money:
    count_2 = S_money // today_price
    S_money -= count_2 * today_price
    S_asset += count_2
  
  past = price[i]
  
final_price = price[13]
J_final = J_money + J_asset * final_price
S_final = S_money + S_asset * final_price

if J_final == S_final:
  print("SAMESAME")
elif J_final > S_final:
  print("BNP")
else: 
  print("TIMING")    
    
  

  