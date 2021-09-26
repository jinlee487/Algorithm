def selectionSort(array):
    # Write your code here.
	for i in range(len(array)):
		smallest = i
		for j in range(i+1,len(array)):
			print(j)
			if array[smallest] > array[j]:
				smallest = j
		temp = array[smallest]
		array[smallest] = array[i]
		array[i] = temp
	return array
    
