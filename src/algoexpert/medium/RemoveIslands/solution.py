def removeIslands(matrix):
    # Write your code here.
    answer = [[0 for _ in matrix[0]] for _ in matrix]
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if 0<i and i<len(matrix)-1 and 0<j and j<len(matrix[0])-1:
                continue
            if matrix[i][j] == 1:
                dfs(i,j,matrix,answer)
    return answer

def dfs(x,y,matrix,answer):
	matrix[x][y] = 0
	answer[x][y] = 1
	xarr = [0,0,-1,1]
	yarr = [1,-1,0,0]
	for i in range(4):
		ny = y + yarr[i]
		nx = x + xarr[i]
		if check(nx,ny,matrix):
			dfs(nx,ny,matrix,answer)
	return
def check(x,y,matrix):
	if x < 0 or len(matrix) <= x:
		return False
	if y < 0 or len(matrix[0]) <= y:
		return False
	if matrix[x][y] != 1:
		return False
	return True
	
	
