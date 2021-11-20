def sameBsts(arrayOne, arrayTwo):
    # Write your code here.
	if len(arrayOne) != len(arrayTwo):
		return False
	if len(arrayOne) == 0 and len(arrayTwo) == 0:
		return True
	if arrayOne[0] != arrayTwo[0]:
		return False
	leftOne = getSmaller(arrayOne)
	leftTwo = getSmaller(arrayTwo)
	rightOne = getBiggerOrEqual(arrayOne)
	rightTwo = getBiggerOrEqual(arrayTwo)

	return sameBsts(leftOne, leftTwo) and sameBsts(rightOne, rightTwo)
def getSmaller(array):
	smaller = []
	for i in range(1, len(array)):
		if array[i] < array[0]:
			smaller.append(array[i])
	return smaller
def getBiggerOrEqual(array):
	biggerOrEqual = []
	for i in range(1, len(array)):
		if array[0] <= array[i]:
			biggerOrEqual.append(array[i])
	return biggerOrEqual
def sameBsts(arrayOne, arrayTwo):
    # Write your code here.
	return sameBstsHelper(arrayOne, arrayTwo, 0, 0, float("-inf"), float("inf"))
def sameBstsHelper(arrayOne, arrayTwo, rootIdxOne, rootIdxTwo, minVal, maxVal):
	if rootIdxOne == -1 or rootIdxTwo == -1:
		return rootIdxOne == rootIdxTwo
	if arrayOne[rootIdxOne] != arrayTwo[rootIdxTwo]:
		return False
	leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal)
	leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal)
	rightRootIdxOne = getIdxOfBiggerOrEqual(arrayOne, rootIdxOne, maxVal)
	rightRootIdxTwo = getIdxOfBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal)
	
	currentValue = arrayOne[rootIdxOne]
	leftAreSame = sameBstsHelper(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue)
	rightAreSame = sameBstsHelper(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal)
	return leftAreSame and rightAreSame
def getIdxOfFirstSmaller(array, rootIdx, minVal):
	for i in range(rootIdx+1,len(array)):
		if array[i] < array[rootIdx] and array[i] >= minVal:
			return i
	return -1
def getIdxOfBiggerOrEqual(array,rootIdx, maxVal):
	for i in range(rootIdx+1,len(array)):
		if array[rootIdx] <= array[i] and array[i] < maxVal:
			return i
	return -1

