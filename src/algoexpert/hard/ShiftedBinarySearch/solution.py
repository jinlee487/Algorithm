def shiftedBinarySearch(array, target):
    # Write your code here.
    left = 0
    v = float('inf')
    for i in range(len(array)):
        if array[i] < v:
            left = i
            v = array[i]
    right = left + len(array) -1
    while left <= right:
        middle = (left + right)//2
        adjusted = check(middle,len(array))
        if array[adjusted] == target:
            return adjusted
        if target < array[adjusted]:
            right = middle - 1
        else:
            left = middle +1
    return -1
def check(index,arrayLength):
    if arrayLength <= index:
        return index - arrayLength
    else:
        return index

def shiftedBinarySearch(array, target):
    # Write your code here.
	return shiftedBinarySearchHelper(array,target,0,len(array)-1)
def shiftedBinarySearchHelper(array,target,left,right):
	if right < left:
		return -1
	middle = (right + left) // 2
	if array[middle] == target:
		return middle
	if array[left] <= array[middle]:
		if array[left] <= target and target < array[middle]:
			return shiftedBinarySearchHelper(array,target,left,middle-1)
		else:
			return shiftedBinarySearchHelper(array,target,middle+1,right)
	else:
		if array[middle] < target and target <= array[right]:
			return shiftedBinarySearchHelper(array,target,middle+1,right)
		else:
			return shiftedBinarySearchHelper(array,target,left,middle-1)
def shiftedBinarySearch(array, target):
    # Write your code here.
    left = 0
    right = len(array)-1
    while left<=right:
        middle = (left + right) // 2
        if array[middle] == target:
            return middle
        if array[left] <= array[middle]:
            if array[left] <= target and target < array[middle]:
                right = middle -1
            else:
                left = middle +1
        else:
            if array[middle] < target and target <= array[right]:
                left = middle +1
            else:
                right = middle -1	
    return -1
        