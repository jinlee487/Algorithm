# https://www.acmicpc.net/problem/2309
# 일곱 난쟁이
# Solved

# 9^9 = 387420489
def brute_force():
    height = []
    for i in range(0,9):
        height.append(int(input()))   
    for i in range(0,9):
        for j in range(0,9):
            for k in range(0,9):
                for l in range(0,9):
                    for m in range(0,9):
                        for n in range(0,9):
                            for o in range(0,9):
                                idx_set = {i,j,k,l,m,n,o}
                                if len(idx_set)!=7:
                                    continue
                                height_list = [height[a] for a in idx_set]
                                height_sum = sum(height_list)
                                if 100==height_sum:
                                    height_list.sort()
                                    for a in height_list:
                                        print(a)
                                    return
brute_force()
