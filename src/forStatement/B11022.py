# https://www.acmicpc.net/problem/11022
# A+B - 8


import sys
 
T = int(sys.stdin.readline())
l = []
for i in range(1,T+1):
    A,B = map(int,sys.stdin.readline().split(" "))
    print("Case #%s: %s + %s = %s"%(i, A, B, A+B ))



