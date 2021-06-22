# https://www.acmicpc.net/problem/11021
# A+B - 7


import sys
 
T = int(sys.stdin.readline())
l = []
for i in range(1,T+1):
    A,B = map(int,sys.stdin.readline().split(" "))
    l.append("Case #"+str(i)+": " + str(A+B))
print("\n".join(l))


