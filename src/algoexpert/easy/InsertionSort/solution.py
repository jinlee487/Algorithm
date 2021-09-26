def insertionSort(array):
    # Write your code here.
	for i in range(len(array)):
		for j in range(i, 0, -1):
			if array[j] < array[j-1]:
				array[j], array[j-1] = array[j-1], array[j]
			else: 
				break
	return array

