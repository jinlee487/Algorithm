# https://www.acmicpc.net/problem/1929
# 소수 구하기

M,N = map(int,input().split(" "))

check = [False for i in range(N+1)]
for i in range(2, int(N**0.6)):
    if check[i] == False:
        for j in range(2 * i, N + 1, i):
            check[j] = True
l = []
for i in range(M, N + 1):
    if i >= 2:
        if check[i] == False:
            l.append(i)

if len(l) != 0:
    for i in l:
        print(i)
