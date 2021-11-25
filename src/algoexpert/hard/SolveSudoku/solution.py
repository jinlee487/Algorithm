def solveSudoku(board):
    # Write your code here.
    zero = []
    for i in range(9):
        for j in range(9):
            if board[i][j] == 0:
                zero.append([i,j])
    solveSudokuHelper(zero,board)
    return board
def solveSudokuHelper(zero,board):
    if len(zero) == 0:
        return True
    x,y = zero.pop()
    for i in range(1,10):
        board[x][y] = i
        if check(x,y,board):
            if solveSudokuHelper(zero,board):
                return True
    board[x][y] = 0
    zero.append([x,y])
    return False
def check(x,y,board):
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

	
				
