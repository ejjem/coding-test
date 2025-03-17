from itertools import combinations
import sys
input = sys.stdin.readline

cards = [i for i in range(1, 11)] * 2

lose = 0
total = 18 * 17 / 2  # 상대방이 가질 수 있는 모든 경우의 수

A, B = map(int, input().split())

cards.remove(A)
cards.remove(B)

# 내 족보 계산
if A == B:
    my_rank = (10 + A)  # 땡
else:
    my_rank = (A + B) % 10  # 끗

# 상대방 가능한 패 모든 조합 구하기 (O(N^2))
for opp_A, opp_B in combinations(cards, 2):
    if opp_A == opp_B:
        opp_rank = (10 + opp_A)  # 상대가 땡
    else:
        opp_rank = (opp_A + opp_B) % 10  # 상대가 끗
    
    # 승패 비교
    if my_rank <= opp_rank:
        lose += 1  # 내가 진 경우만 카운트
        
answer = (total - lose) / total
print(f"{answer:.3f}")