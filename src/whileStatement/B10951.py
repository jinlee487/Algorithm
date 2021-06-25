# https://www.acmicpc.net/problem/10951
# A+B - 4

while True:
    try:
        A,B = map(int,input().split(" "))
    except:
        break
    print(A+B)
