import sys
class Solution(object):
    def minPathSum(self, grid):
        answer = []
        for i in range(len(grid)):
            self.arr = [] 
            self.xarr = [-1,1,0,0]
            self.yarr = [0,0,1,-1]
            for j in range(5):
                self.arr.append(list(grid[i][j]))
            self.visit = [[False for i in range(len(self.arr[0]))] for i in range(len(self.arr))]
            print(self.visit)
            print(self.arr)
            if self.init():
                answer.append(1)
            else:
                answer.append(0)
        return answer
    def init(self):
        for i in range(5):
                for j in range(5):
                    if self.arr[i][j] == 'P':
                        self.visit[i][j] = True
                        if not self.dfs(0,0,0):
                            return False
        return True

    def check(self,x,y):
        if x<0 or y<0 or len(self.arr)<=x or len(self.arr[0])<=y:
            return False
        if self.arr[x][y] == 'X':
            return False
        if self.visit[x][y] == True:
            return False 
        return True

    def dfs(self,x,y,count):      
        if self.visit[x][y] == False and self.arr[x][y] == 'P':
            return False
        self.visit[x][y] = True
        if 1 < count:
            return True
        for i in range(4):
            nx = self.xarr[i]+x
            ny = self.yarr[i]+y
            if self.check(nx,ny):
                if not self.dfs(nx,ny,count+1):
                    return False
        return True



grid = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
# grid = [["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"]]

run = Solution()
print(run.minPathSum(grid))