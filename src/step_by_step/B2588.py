# https://www.acmicpc.net/problem/2588
# 곱셈
x = int(input())
y = int(input())
 
print(x*((y%100)%10), x*((y%100)//10), x*(y//100), x*y, sep='\n')
