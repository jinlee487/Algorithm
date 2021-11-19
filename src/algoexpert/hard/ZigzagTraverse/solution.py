def zigzagTraverse(array):
    # Write your code here.
	answer = []
	i = 0
	j = 0
	row = len(array)-1
	column = len(array[0])-1
	answer.append(array[i][j])
	while i <= row and j <= column:
		if (i+j) % 2 == 0:
			if check(i+1,j-1,row,column):
				i+=1
				j-=1
				answer.append(array[i][j])
			elif check(i+1,j,row,column):
				i+=1
				answer.append(array[i][j])
			elif check(i,j+1,row,column):
				j+=1
				answer.append(array[i][j])
		else:
			if check(i-1,j+1,row,column):
				i-=1
				j+=1
				answer.append(array[i][j])
			elif check(i,j+1,row,column):
				j+=1
				answer.append(array[i][j])
			elif check(i+1,j,row,column):
				i+=1
				answer.append(array[i][j])
		if i==row and j==column: 
			break
	return answer

def check(i,j,row,column):
	if i<0 or row<i:
		return False
	if j<0 or column<j:
		return False
	return True