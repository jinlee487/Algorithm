# https://www.acmicpc.net/problem/2741
# N 찍기


import sys
 
N = int(sys.stdin.readline())
l = []
for i in reversed(range(1,N+1)):
    l.append(str(i))
print("\n".join(l))


