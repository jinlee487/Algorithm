# https://www.acmicpc.net/problem/2775
# 부녀회장이 될테야
# 4층	1	6	21	56	126
# 3층	1	5	15	35	70
# 2층	1	4	10	20	35
# 1층	1	3	6	10	15
# 0층	1	2	3	4	5
T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    f0 = [x for x in range(1, n+1)]
    for j in range(k):
        for i in range(1, n):
            f0[i] += f0[i-1]
        # print(f0)  # 프린트문을 추가
    print(f0[-1])
    
    