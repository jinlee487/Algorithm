# this is n^2 time
def twoNumberSum(array, targetSum):
    # Write your code here.
	for i in range(len(array)-1):
		for j in range(i+1,len(array)):
			if array[i] + array[j] == targetSum:
				return [array[i],array[j]]
	return []
    

# this is O(n)time
def twoNumberSum(array, targetSum):
    # Write your code here.
	dic = {}
	for i in range(len(array)):
		temp = targetSum - array[i]
		if temp in dic:
			return [temp, array[i]]
		else:
			dic[array[i]] = True
	return [] 
    

# O(nlog(n))
def twoNumberSum(array, targetSum):
    # Write your code here.
	array.sort()
	left = 0 
	right = len(array)-1
	while left < right:
		temp = array[left] + array[right]
		if temp == targetSum:
			return [array[left],array[right]]
		elif temp < targetSum:
			left += 1
		elif temp > targetSum:
			right -= 1
	return []
    
