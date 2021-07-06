# https://leetcode.com/problems/minimum-path-sum/
# Minimum Path Sum
# solved

# import sys
# class Solution(object):
#     def minPathSum(self, grid):
#         self.arr = grid
#         self.xarr = [1,0]
#         self.yarr = [0,1]
#         self.minSum = sys.maxsize
#         self.visit = [[False for i in range(len(self.arr[0]))] for i in range(len(self.arr))]

#         # print(self.xarr)
#         # print(self.yarr)
#         # print(self.minSum)
#         # print(self.visit[0][0])
#         # print(self.visit)

#         self.visit[0][0]=True
#         self.dfs(0,0,0)
#         return self.minSum

#     def check(self,x,y):
#         # print("check")
#         # print(x)
#         # print(y)
#         if x<0 or y<0 or len(self.arr)<=x or len(self.arr[0])<=y:
#             # print("first false check")
#             return False
#         if self.visit[x][y] == True:
#             # print(self.visit)
#             # print("second false check")
#             return False 
#         return True

#     def dfs(self,x,y,currSum):
#         currSum += self.arr[x][y]
#         # print(self.visit)
#         # print("x=" + str(x) + " y=" + str(y) + " currSum="+str(currSum))
#         if x == len(self.arr)-1 and y == len(self.arr[0])-1:
#             if currSum < self.minSum:
#                 self.minSum = currSum
#             return 
#         if currSum > self.minSum:
#             return

#         for i in range(2):
#             nx = self.xarr[i]+x
#             ny = self.yarr[i]+y
#             # print("nx=" + str(nx) +" ny="+str(ny))
#             if self.check(nx,ny):
#                 self.visit[nx][ny] = True
#                 self.dfs(nx,ny,currSum)
#                 self.visit[nx][ny] = False
#         return


import sys
class Solution(object):
    def minPathSum(self, grid):
        for i in grid:
            i.insert(0,sys.maxsize) 
        grid.insert(0,[sys.maxsize for i in range(len(grid[0]))])
        grid[1][0] = 0
        # print(grid)
        for i in range(1,len(grid)):
            for j in range(1,len(grid[0])):
                # print("grid[i][j-1] "+str(grid[i][j-1]))
                # print("grid[i][j-1] "+str(grid[i-1][j]))

                grid[i][j] += min(grid[i][j-1],grid[i-1][j])
        # print(grid)
        return grid[len(grid)-1][len(grid[0])-1]


grid = [[1,2,3],[4,5,6]] # 12
        
grid = [[1,3,1],[1,5,1],[4,2,1]] #7

grid = [[7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5],[9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6],[8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8],[6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4],[7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4],[9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9],[1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4],[3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2],[1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3],[5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7],[2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7],[0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9]]
run = Solution()
print(run.minPathSum(grid))

