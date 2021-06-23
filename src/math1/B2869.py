# https://www.acmicpc.net/problem/2869
# 달팽이는 올라가고 싶다
import math
A,B,V = map(int,input().split(" "))
V -= B
print(int(math.ceil(V/(A-B))))