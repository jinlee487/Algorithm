def arrayOfProducts(array):
    # Write your code here.
	answer = [1 for _ in range(len(array))] 
	leftProduct = 1
	rightProduct = 1
	for i in range(len(array)):
		answer[i] = leftProduct 
		leftProduct *= array[i] 
	for i in reversed(range(len(array))):
		answer[i] *= rightProduct;
		rightProduct *= array[i]
	return answer
    
def arrayOfProducts(array):
    # Write your code here.
	product = 1
	count = 0
	for num in array:
		if num == 0:
			count += 1
			continue
		product *= num
	for i in range(len(array)):

		if array[i] == 0 and count == 1:
			array[i] = product
		elif count > 0:
			array[i] = 0
		else:
			array[i] = product/array[i]
	return array
    
