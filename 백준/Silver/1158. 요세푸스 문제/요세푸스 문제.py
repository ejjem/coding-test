n, k = map(int, input().split())
people = list(range(1, n + 1)) 
k_1 = 0
answer = []

for i in range(n):
	k_1 = (k_1 + k - 1) % len(people)
	answer.append(people.pop(k_1))

print('<' + ', '.join(map(str, answer)) + '>')