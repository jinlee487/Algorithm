def moveElementToEnd(array, toMove):
    # Write your code here.
    count = 0
    answer = [] 
    for a in array:
        if a == toMove:
            count += 1
        else: 
            answer.append(a)
    for i in range(count):
        answer.append(toMove)
    return answer

def moveElementToEnd(array, toMove):
    # Write your code here.
	left, right = 0, len(array) - 1 
	while left < right:
		while array[right] == toMove and left < right:
			right -= 1
		if array[left] == toMove:
			array[left], array[right] = array[right], array[left]
		left += 1
	return array
