

n = int(input())
l = []
for _ in range(19):
    l.append([0]*19)

for i in range(n):
    x,y = map(int,input().split())
    l[x-1][y-1] = 1

for i in range(19):
    for j in range(19):
        print(l[i][j],end=" ")
    print()        
# class Point2D:
#     def __init__(self, x=0, y=0):
#         self.x = x
#         self.y = y
 
# length = 0.0
# p = [Point2D(), Point2D(), Point2D(), Point2D()]
# p[0].x, p[0].y, p[1].x, p[1].y, p[2].x, p[2].y, p[3].x, p[3].y = map(int, input().split())

# for i in range(1,len(p)):
#     a = p[i-1].x - p[i].x    # 선 a의 길이
#     b = p[i-1].y - p[i].y    # 선 b의 길이
#     length += math.sqrt((a * a) + (b * b))


# print(length)
