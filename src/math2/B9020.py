# https://www.acmicpc.net/problem/9020
# 골드바흐의 추측


l = [0 for i in range(10001)]
l[1] = 1
for i in range(2, 98):
    for j in range(i * 2, 10001, i):
        l[j] = 1
t = int(input())
for i in range(t):
    a = int(input())
    b = a // 2
    for j in range(b, 1, -1):
        if l[a - j] == 0 and l[j] == 0:
            print(j, a - j)
            break
