import sys
input = sys.stdin.readline
N, K = map(int, input().split())
A = list(map(int, input().split()))
answer = -1
count = 0
def merge_sort (list, left, right): #의사 코드에서 p = left, r = right, q = mid
    if (left < right):
        mid = (left + right) // 2
        merge_sort(list, left, mid)
        merge_sort(list, mid + 1, right)
        merge(A, left, mid, right)

def merge(list, left, mid, right):
    i = left
    j = mid + 1
    global count
    tmp = []
    while i <= mid and j <= right:
        if list[i] <= list[j]:
            tmp.append(A[i])
            i += 1
        else:
            tmp.append(A[j])
            j += 1
    while i <= mid:
        tmp.append(A[i])
        i += 1
    while j <= right:
        tmp.append(A[j])
        j += 1
    
    i = left
    t = 0
    while i <= right:
        A[i] = tmp[t]
        count += 1
        if count == K:
            global answer
            answer = tmp[t]            
        i += 1
        t += 1

merge_sort(A, 0, N-1)
#print(A)
print(answer)
