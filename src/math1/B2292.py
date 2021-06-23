# https://www.acmicpc.net/problem/2292
# 벌집

N = int(input())
start = 1
count = 1
for i in range(0,1000000000):
    start+=6*i
    if N<=start:
        break
    count += 1    
print(count)