# https://programmers.co.kr/learn/courses/30/lessons/42587?language=python3
# 프린터


def solution(priorities, location):
    l = []
    l2 = []
    for i in range(0,len(priorities)):
        l.append([priorities[i],i])
    check=False
    while len(l)!=0:
        current = l.pop(0)
        for next in l:
            if current[0]<next[0]:
                l.append(current)
                check = True
                break
        if check==False:
            l2.append(current)
        check = False
    for i in range(0,len(l2)):
        if l2[i][1] == location:
            answer = i + 1
            break
    return answer

    
priorities = [2, 1, 3, 2]
location = 	2
print(solution(priorities,location))