# https://www.acmicpc.net/problem/1193
# 분수찾기
# 1 2 6 7 15
# 3 5 8 14
# 4 9 13
# 10 12 
# 11
X = int(input())
line=1
while X>line:
    # print("loop")
    X-=line
    line+=1
    # print("x="+str(X))
    # print("line="+str(line))
if line%2==0:
    a=X
    b=line-X+1
    # print("a="+str(a))
    # print("b="+str(b))
else:
    a=line-X+1
    b=X
    # print("a="+str(a))
    # print("b="+str(b))
    
print(a, '/', b, sep='')
