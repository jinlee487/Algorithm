# https://www.acmicpc.net/problem/10952
# A+B - 5

while True:
    A,B = map(int,input().split(" "))
    if A+B == 0:
        break
    print(A+B)
