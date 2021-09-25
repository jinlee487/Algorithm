def findThreeLargestNumbers(array):
    # Write your code here.
	array.sort(reverse=True)
	return [array[2],array[1],array[0]]

def findThreeLargestNumbers(array):
    # Write your code here.
    answer = [None, None, None]
    for n in array:
        if answer[2] is None or n > answer[2]:
            findThreeLargestNumbersHelper(answer, n, 2)
        elif answer[1] is None or n > answer[1]:
            findThreeLargestNumbersHelper(answer, n, 1)
        elif answer[0] is None or n > answer[0]:
            findThreeLargestNumbersHelper(answer, n, 0)
    return answer
    
def findThreeLargestNumbersHelper(answer, n, idx):
	for i in range(idx + 1):
		if i == idx:
			answer[i] = n
		else: 
			answer[i] = answer[i + 1]

