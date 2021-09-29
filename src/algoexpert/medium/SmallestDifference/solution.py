def smallestDifference(arrayOne, arrayTwo):
    # Write your code here.
	arrayOne.sort()
	arrayTwo.sort()
	smallest = float("inf")
	current = float("inf")
	idxOne = 0
	idxTwo = 0
	answer = [0,0]
	while idxOne<len(arrayOne) and idxTwo<len(arrayTwo):
		first = arrayOne[idxOne]
		second = arrayTwo[idxTwo]
		if first < second:
			current = second - first
			idxOne += 1
		elif second < first:
			current = first - second
			idxTwo += 1
		else:
			return [first,second]
		if current < smallest:
			answer[0] = first
			answer[1] = second
			smallest = current
	return answer

def smallestDifference(arrayOne, arrayTwo):
    # Write your code here.
    diff = float("inf") 
    answer = [0,0]
    for first in arrayOne:
        for second in arrayTwo:
            if abs(first - second)<diff:
                diff = abs(first - second)
                answer[0] = first
                answer[1] = second
    return answer
		
