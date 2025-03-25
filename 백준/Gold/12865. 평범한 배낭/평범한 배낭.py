import sys
input = sys.stdin.readline

# 입력 처리
N, K = map(int, input().split())
Data = [tuple(map(int, input().split())) for _ in range(N)]  # 물품 정보 (무게, 가치)

# DP 배열 초기화
dp = [0] * (K + 1)

# DP 업데이트
for W, V in Data:
    for w in range(K, W - 1, -1):  # 역순으로 무게를 순회
        dp[w] = max(dp[w], dp[w - W] + V)

# 최대 가치 출력
print(dp[K])
