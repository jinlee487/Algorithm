def maxSubsetSumNoAdjacent(array):
    # Write your code here.
	if len(array) == 0: 
		return 0
	if len(array) == 1:
		return array[0]
	array[1]= max(array[0],array[1])
	for i in range(2,len(array)):
		array[i] = max(array[i-1],array[i]+array[i-2])
	return array[len(array)-1]
    
