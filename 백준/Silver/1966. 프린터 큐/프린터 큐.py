from queue import Queue

testcase = int(input())

for i in range(testcase):
    answer = 0  #출력 횟수
    N, M = map(int, input().split())    #N: 문서의 개수, M: 몇 번째로 인쇄되는지 궁금한 문서
    priority = list(map(int, input().split()))
    priority2 = sorted(priority, reverse = True)
    q = Queue()
    for i in range(N):
        if i == M:
            q.put(str(priority[i]))
        else:
            q.put(priority[i])
    j = 0
    while True: 
        tmp = q.get()
        if int(tmp) == priority2[j]:
            answer += 1
            if type(tmp) == str:
                print(answer)
                break;
            j += 1;
        else:
            q.put(tmp)