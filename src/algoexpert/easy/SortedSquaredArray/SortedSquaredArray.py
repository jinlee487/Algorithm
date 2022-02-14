def sortedSquaredArray(array):
    # Write your code here.
	answer = []
	for num in array:
		answer.append(num * num)
	answer.sort()
    return answer
def sortedSquaredArray(array):
    # Write your code here.
	answer = [0 for _ in array] 
	left = 0 
	right = len(array)-1
	for i in reversed(range(len(array))):
		small = array[left]
		large = array[right]
		if abs(small)>abs(large):
			answer[i] = small*small
			left += 1
		else:
			answer[i] = large*large
			right-=1
	return answer
