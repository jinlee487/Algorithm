def waterArea(heights):
    # Write your code here.
	if len(heights) == 0:
		 return 0
	leftIdx = 0
	rightIdx = len(heights) -1 
	leftMax = heights[leftIdx]
	rightMax = heights[rightIdx]
	surfaceArea = 0
	
	while leftIdx < rightIdx:
		if heights[leftIdx] < heights[rightIdx]:
			leftIdx += 1
			leftMax = max(leftMax, heights[leftIdx])
			surfaceArea += leftMax - heights[leftIdx]
		else:
			rightIdx -= 1
			rightMax = max(rightMax, heights[rightIdx])
			surfaceArea += rightMax - heights[rightIdx]
	return surfaceArea
def waterArea(heights):
    # Write your code here.
	maxes = [0 for _ in heights]
	leftMax = 0
	for i in range(len(heights)):
		height = heights[i]
		maxes[i] = leftMax
		leftMax = max(leftMax,height)
	rightMax = 0
	for i in reversed(range(len(heights))):
		height = heights[i]
		minHeight = min(rightMax,maxes[i])
		if height < minHeight: 
			maxes[i] = minHeight - height
		else:
			maxes[i] = 0
		rightMax = max(rightMax,height)
	return sum(maxes)
def waterArea(heights):
    # Write your code here.
	if len(heights)==0: 
		return 0
	maxArr = [0,0]
	for i in range(len(heights)):
		if maxArr[0] <= heights[i]:
			maxArr[0] = heights[i]
			maxArr[1] = i
	answer = 0
	currentMaxHeight = 0
	for i in range(maxArr[1]):
		if currentMaxHeight < heights[i]:
			currentMaxHeight = heights[i]
		else:
			answer += currentMaxHeight - heights[i]
    currentMaxHeight = 0
	for i in reversed(range(maxArr[1]+1,len(heights))):
		if currentMaxHeight < heights[i]:
			currentMaxHeight = heights[i]
		else:
			answer += currentMaxHeight - heights[i]
	return answer