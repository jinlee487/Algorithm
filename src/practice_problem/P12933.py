# https://programmers.co.kr/learn/courses/30/lessons/12933
# 정수 내림차순으로 배치하기
# Solved!

def solution(n):
    l = list(str(n))
    l.sort(reverse=True)
    answer = "".join(l)
    return int(answer)