# https://www.acmicpc.net/problem/1978
# 소수 찾기

N = int(input())
l = list(map(int,input().split()))
count = 0
for i in l:
    if 1<i:
        count += 1
        for j in range(2,i):
            if(i%j==0):
                count-=1
                break
print(count)
