def riverSizes(matrix):
    # Write your code here.
    answer = []
    visited = [[False for value in row] for row in matrix]
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if visited[i][j] is False and matrix[i][j] == 1:
                answer.append(dfs(i,j,matrix,visited,1))
    return answer
def dfs(x,y,matrix,visited,count):
	visited[x][y] = True
	xarr = [0,0,1,-1]
	yarr = [1,-1,0,0]
	for i in range(4):
		nx = x + xarr[i]
		ny = y + yarr[i]
		if check(nx,ny,matrix,visited):
			count = dfs(nx,ny,matrix,visited,count+1)
	return count
def check(x,y,matrix,visited):
	if x < 0 or x >= len(matrix):
		return False
	if y < 0 or y >= len(matrix[x]):
		return False
	if matrix[x][y] != 1:
		return False
	if visited[x][y]:
		return False
	return True
def riverSizes(matrix):
    # Write your code here.
    answer = []
    visited = [[False for value in row] for row in matrix]
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if visited[i][j] is False:
                traverseNode(i,j,matrix,visited,answer)
    return answer
def traverseNode(i,j,matrix,visited,answer):
	current = 0
	nodes = [[i,j]]
	while len(nodes):
		currentNode = nodes.pop()
		i = currentNode[0]
		j = currentNode[1]
		if visited[i][j]:
			continue
		visited[i][j] = True
		if matrix[i][j] == 0:
			continue
		current +=1 
		neighbors = getNeighbors(i,j,matrix,visited)
		for neighbor in neighbors:
			nodes.append(neighbor)
	if current > 0:
		answer.append(current)
	return
def getNeighbors(i,j,matrix,visited):
	neighbors=[]
	iarr = [0,0,1,-1]
	jarr = [1,-1,0,0]
	for k in range(4):
		ni = i + iarr[k]
		nj = j + jarr[k]
		if ni < 0 or ni>=len(matrix) or nj < 0 or nj>=len(matrix[i]):
			continue
		neighbors.append([ni,nj])
	return neighbors