import sys
input = sys.stdin.readline
N = int(input())
M = int(input())
materials = list(map(int, input().split()))
materials.sort()
start_index = 0
end_index = N - 1
count = 0
sum = materials[start_index] + materials[end_index]
while start_index < end_index:
  if sum == M:
    count += 1
    start_index += 1
    end_index -= 1
    sum = materials[start_index] + materials[end_index]
  elif sum < M:
    start_index += 1
    sum = materials[start_index] + materials[end_index]
  elif sum > M:
    end_index -= 1
    sum = materials[start_index] + materials[end_index]
print(count)