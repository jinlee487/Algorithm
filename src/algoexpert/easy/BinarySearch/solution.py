def binarySearch(array, target):
    # Write your code here.
    return binarySearchHelper(array, target, 0, len(array) - 1)

def binarySearchHelper(array, target, left, right):
	while(left<=right):
		mid = (left + right) // 2
		if array[mid] == target:
			return mid
		elif target < array[mid]: 
			right = mid - 1 
		else:
			left = mid + 1
	return -1

def binarySearchHelper(array, target, left, right):
	if left > right: 
		return -1
	mid = (left + right) // 2
	if array[mid] == target:
		return mid
	elif target < array[mid]:
		return binarySearchHelper(array, target, left, mid - 1)
	else:
		return binarySearchHelper(array, target, mid + 1, right)
