def kadanesAlgorithm(array):
    # Write your code here.
    answer = array[0]
	for i in range(1,len(array)):
		array[i] = max(array[i],array[i]+array[i-1])
		answer = max(array[i],answer)
	return answer
