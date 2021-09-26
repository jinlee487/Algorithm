def bubbleSort(array):
    # Write your code here.
	if len(array) < 2:
		return array
	sorted = False
	l = len(array)
	while sorted is False:
		sorted = True
		for i in range(1,l):
			if array[i] < array[i-1]:
				array[i], array[i-1] = array[i-1], array[i]
				sorted = False
		l -= 1			
	return array
    
