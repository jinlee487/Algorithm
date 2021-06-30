# https://programmers.co.kr/learn/courses/30/lessons/42584?language=python3
# 주식가격
# Solved!


def solution(prices):
    answer = []
    for i in range(0,len(prices)):
        for j in range(i+1,len(prices)+1):
            if j == len(prices):
                answer.append(j-i-1)
                break
            if prices[j] < prices[i]:
                answer.append(j-i)
                break
    return answer

prices = [1,2,3,2,3]
print(solution(prices))
# [4, 3, 1, 1, 0]