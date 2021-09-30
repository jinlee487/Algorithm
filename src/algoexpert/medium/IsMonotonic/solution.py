def isMonotonic(array):
    # Write your code here.
	if len(array) <= 2: 
		return True
	direction = array[1] - array[0]
	for i in range(2,len(array)):
		if direction == 0:
			direction = array[i] - array[i-1]
			continue
		difference = array[i] - array[i-1]
		if direction < 0:
			if difference > 0:
				return False
		if direction > 0:
			if difference < 0:
				return False
	return True
			
def isMonotonic(array):
    # Write your code here.
	isNonDecreasing = True
	isNonIncreasing = True
	for i in range(1,len(array)):
		if array[i] < array[i-1]:
			isNonIncreasing = False
		if array[i] > array[i-1]:
			isNonDecreasing = False
	return isNonIncreasing or isNonDecreasing
    
