def spiralTraverse(array):
    # Write your code here.
	answer = [] 
	startRow, endRow, startCol, endCol = 0, len(array)-1, 0, len(array[0])-1
	while startRow<=endRow and startCol<=endCol:
		for col in range(startCol,endCol+1):
			answer.append(array[startRow][col])
		for row in range(startRow+1,endRow+1):
			answer.append(array[row][endCol])
		for col in reversed(range(startCol,endCol)):
			if startRow == endRow: 
				break
			answer.append(array[endRow][col])
		for row in reversed(range(startRow+1,endRow)):
			if startCol == endCol:
				break
			answer.append(array[row][startCol])
		startRow+=1
		startCol+=1
		endRow-=1
		endCol-=1
	return answer
    
def spiralTraverse(array):
    # Write your code here.
	answer = [] 
	if len(array) == 0:
		return answer
	spiralTraverseHelper(array, 0, len(array)-1, 0, len(array[0])-1, answer)
	return answer
def spiralTraverseHelper(array, startRow, endRow, startCol, endCol, answer):
	if endRow < startRow or endCol < startCol:
		return 
	for col in range(startCol, endCol+1):
		answer.append(array[startRow][col])
	for row in range(startRow+1, endRow+1):
		answer.append(array[row][endCol])
	for col in reversed(range(startCol,endCol)):
		if startRow == endRow:
			break
		answer.append(array[endRow][col])
	for row in reversed(range(startRow+1,endRow)):
		if startCol == endCol:
			break
		answer.append(array[row][startCol])
	spiralTraverseHelper(array, startRow+1,endRow-1,startCol+1,endCol-1,answer)
