def is_good(n):
    for length in range(1, int(len(n)/2)+1):
        for i in range(len(n)-length):
            if n[i:i+length] == n[i+length:i+length*2]:
                return False
    return True

def next(n):
    n[len(n)-1] += 1
    for i in range(len(n)):
        idx = len(n)-i-1
        if n[idx] <= 3:
            continue
        n[idx] = 1
        if idx != 0:
            n[idx-1] += 1
    return n

n = int(input())

num = [1] * n
max = [3] *(n+1)
while num != max:
    if is_good(num):
        break
    num = next(num)

for i in range(len(num)):
    print(num[i], end='')