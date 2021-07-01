# https://www.acmicpc.net/problem/6603
# 로또
# solved

def dfs(l,k,ans,idx,cnt):
    if k<cnt:
        return True
    if len(ans) == 6:
        print(" ".join(ans))
        return
    for i in range(idx,len(l)):
        ans.append(str(l[i]))
        if dfs(l,k,ans,i+1,cnt) == True:
            return
        ans.pop()
    return False

while True:
    temp = list(map(int,input().split(" ")))
    k = temp[0]
    if k == 0:
        break
    temp.pop(0)
    l = temp
    answer = [] 
    dfs(l,k,answer,0,0)
    print("")