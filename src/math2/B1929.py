# https://www.acmicpc.net/problem/1929
# 소수 구하기

M,N = map(int,input().split(" "))

r = N + 1

check = [False for _ in range(r)]
for i in range( 2, int(r**0.8) ) : # 2부터 ~ 범위(r)의 제곱근까지
    if check[i] == False : # 지워지지 않고, 가장 작은수라면
        for j in range( i*2 , r, i ): # i의 2배수 부터, 3배수, 4배수, .... 범위끝까지 지운다.(True로)
            check[j] = True
prime_number = [i for i,j in enumerate(check) if i>=2 and j==False]

for i in prime_number:
    if N >= i >= M:
        print(i)