# https://www.acmicpc.net/problem/1330
# 수 비교
A,B = map(int,input().split(" "))
if A>B:
    print(">")
elif A<B:
    print("<")
else:
    print("==")