# https://www.acmicpc.net/problem/10950
# A+B - 3
T = int(input())
l = []
for _ in range(T):
    A,B = map(int,input().split(" "))
    l.append(str(A+B))
print("\n".join(l))