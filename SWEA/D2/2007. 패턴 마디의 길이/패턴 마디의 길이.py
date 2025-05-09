T = int(input())

for tc in range(1, T + 1):
    s = input().strip()
    for i in range(1, 11):  # 마디 최대 길이 10
        if s[:i] == s[i:2*i]:
            print(f"#{tc} {i}")
            break