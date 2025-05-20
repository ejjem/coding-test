MOD = 1234567891
MAX = 1000000

# 팩토리얼과 역팩토리얼 미리 계산
fact = [1] * (MAX + 1)
inv_fact = [1] * (MAX + 1)

for i in range(1, MAX + 1):
    fact[i] = (fact[i - 1] * i) % MOD

# 역팩토리얼 계산 (페르마의 소정리 이용)
inv_fact[MAX] = pow(fact[MAX], MOD - 2, MOD)
for i in range(MAX, 0, -1):
    inv_fact[i - 1] = (inv_fact[i] * i) % MOD

# 테스트케이스 입력
T = int(input())
for tc in range(1, T + 1):
    N, R = map(int, input().split())
    # 조합: N! / (R! * (N-R)!) mod MOD
    answer = fact[N] * inv_fact[R] % MOD
    answer = answer * inv_fact[N - R] % MOD
    print(f"#{tc} {answer}")
