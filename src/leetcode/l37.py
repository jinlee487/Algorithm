from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        zero = []
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    zero.append([i,j])
        self.solveSudokuHelper(board,zero)
        
    def solveSudokuHelper(self, board: List[List[str]], zero: List[List[int]]) -> bool:
        if len(zero) == 0:
            return True
        x,y = zero.pop()
        for i in range(1,10):
            board[x][y] = str(i)
            if self.check(board,x,y):
                if self.solveSudokuHelper(board,zero):
                    return True
        board[x][y] = "."
        zero.append([x,y])
        return False

    def check(self, board: List[List[str]], x: int, y: int) -> bool:
        n = board[x][y]
        for i in range(9):
            if i == y: 
                continue
            if n == board[x][i]:
                return False
        for i in range(9):
            if i == x: 
                continue
            if n == board[i][y]:
                return False
        nx = x//3 *3
        ny = y//3 *3
        for i in range(3):
            for j in range(3):
                if nx + i == x and ny + j == y:
                    continue
                if board[nx + i][ny + j] == n:
                    return False
        return True

    def print(self, board: List[List[str]]) -> None:
        print("")
        for i in range(len(board)):
            print(board[i])
        return 

                


solution = Solution()
input = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
solution.solveSudoku(input)
solution.print(input)