import sys
input = sys.stdin.readline
MAXSIZE = 10000
deque = list(range(MAXSIZE))
noforder = int(input())
global front, rear
front, rear = 0, 0
for i in range(noforder):
    order = input().split()

    if order[0] == 'push_front':
        deque[front] = int(order[1])
        front = (front - 1) % MAXSIZE

    elif order[0] == 'push_back':
        rear = (rear + 1) % MAXSIZE
        deque[rear] = int(order[1])

    elif order[0] == 'pop_front':
        if front == rear:
            print(-1)
        else:
            front = (front + 1) % MAXSIZE
            print(deque[front])

    elif order[0] == 'pop_back':
        if front == rear:
            print(-1)
        else:
            print(deque[rear])
            rear = (rear - 1) % MAXSIZE

    elif order[0] == 'size':
        print((rear - front + MAXSIZE) % MAXSIZE)

    elif order[0] == 'empty':
        if front == rear:
            print(1)
        else:
            print(0)

    elif order[0] == 'front':
        if front == rear:
            print(-1)
        else:
            print(deque[(front+1) % MAXSIZE])

    elif order[0] == 'back':
        if front == rear:
            print(-1)
        else:
            print(deque[rear])