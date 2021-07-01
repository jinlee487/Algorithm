# https://www.acmicpc.net/problem/17609
# 회문
# Solved
import sys

T = int(sys.stdin.readline())

def B17609(str):
    left_false = False
    right_false = False
    for i in range(len(str)//2):
        if str[i] != str[len(str)-1-i]:
            # 앞 글자 삭제후 비교
            for j in range(i,len(str)//2):
                if str[j+1] != str[len(str)-1-j]:
                    left_false = True

            # 뒤 글자 삭제후 비교
            for j in range(i,len(str)//2):
                if str[j] != str[len(str)-1-j -1]:
                    right_false = True 
            
            if left_false and right_false:
                return 2
            elif left_false or right_false:
                return 1
    return 0

for _ in range(T):
    print(B17609(sys.stdin.readline().rstrip()))

