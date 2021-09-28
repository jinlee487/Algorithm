def threeNumberSum(array, targetSum):
    # Write your code here.
	array.sort()
	answer = []
	for i in range(len(array)):
		left = i+1
		right = len(array)-1
		target = targetSum - array[i]
		while left < right:
			current = array[left] + array[right]
			if target == current:
				answer.append([array[i],array[left],array[right]])
				left +=1
				right -=1
			elif target < current:
				right -=1
			elif target > current:
				left +=1
	return answer
