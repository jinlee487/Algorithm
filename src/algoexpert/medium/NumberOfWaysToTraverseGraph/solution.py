def numberOfWaysToTraverseGraph(width, height):
    # Write your code here.
    if width==1 or height==1:
        return 1
    return numberOfWaysToTraverseGraph(width-1,height) + numberOfWaysToTraverseGraph(width,height-1)
def numberOfWaysToTraverseGraph(width, height):
    # Write your code here.
    arr = [[0 for _ in range(width+1)] for _ in range(height+1)]
    for i in range(1,height+1):
        for j in range(1,width+1):
            if i == 1 or j == 1:
                arr[i][j] = 1
            else:
                arr[i][j] = arr[i-1][j] + arr[i][j-1]
    return arr[height][width]
def numberOfWaysToTraverseGraph(width, height):
    # Write your code here.
    return factorial(width-1+height-1)/factorial(width-1)/factorial(height-1)
def factorial(num):
	f = 1
	for i in range(1,num+1):
		f *= i
	return f
    