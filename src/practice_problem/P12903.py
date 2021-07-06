# https://programmers.co.kr/learn/courses/30/lessons/12903
# 가운데 글자 가져오기
# solved

def solution(s):
    answer = ''
    l = len(s)
    if l%2 == 0:
        answer=s[l//2-1:l//2+1]
    else:
        answer=s[l//2:l//2+1]
    return answer


s = "abcde" # "c"
s = "qwer" # "we"
s = "a"
s = "bc"
print(solution(s))