def minimumPassesOfMatrix(matrix):
	# Write your code here.
	que = []
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if 0<matrix[i][j]:
				que.append([i,j,0])
	count = bfs(matrix,que)
	for i in range(len(matrix)):
		for j in range(len(matrix[0])):
			if matrix[i][j]<0:
				return -1
	return count
def bfs(matrix,que):
	xarr = [0,0,-1,1]
	yarr = [1,-1,0,0]
	count = 0
	while len(que) > 0:
		current = que.pop(0)
		count = max(count,current[2])
		for i in range(4):
			nx = xarr[i] + current[0]
			ny = yarr[i] + current[1]
			if check(nx,ny,matrix):
				matrix[nx][ny] *= -1
				que.append([nx,ny,current[2]+1])
	return count
def check(x,y,matrix):
	if x < 0 or len(matrix) <= x:
		return False
	if y < 0 or len(matrix[0]) <= y:
		return False
	if 0 <= matrix[x][y]:
		return False
	return True