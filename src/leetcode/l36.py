from os import truncate
import time
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                if self.check(i,j,board) == False:
                    return False
        return True
    def check(self, x: int, y: int, board: List[List[str]]) -> bool:
        s = set()
        for i in range(9):
            if board[x][i] == ".":
                continue
            if board[x][i] in s:
                return False
            else:
                s.add(board[x][i])
        s = set()
        for i in range(9):
            if board[i][y] == ".":
                continue
            if board[i][y] in s:
                return False
            else:
                s.add(board[i][y])
        nx = x//3 *3
        ny = y//3 *3
        s = set()
        for i in range(3):
            for j in range(3):
                if board[nx + i][ny + j] == ".":
                    continue
                if board[nx + i][ny + j] in s:
                    return False
                else: 
                    s.add(board[nx + i][ny + j])
        return True
    def print(self, board: List[List[str]]) -> None:
        print("")
        for i in range(len(board)):
            print(board[i])
        return 


solution = Solution()
input = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
print(solution.isValidSudoku(input))