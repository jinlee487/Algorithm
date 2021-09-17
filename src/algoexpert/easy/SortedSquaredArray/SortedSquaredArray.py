def sortedSquaredArray(array):
    # Write your code here.
	answer = []
	for num in array:
		answer.append(num * num)
	answer.sort()
    return answer
