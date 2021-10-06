def mergeOverlappingIntervals(intervals):
    # Write your code here.
	answer = [] 
	array = sorted(intervals, key=lambda x: x[0])
	
	currentInterval = array[0]
	answer.append(currentInterval);
	
	for nextInterval in array:
		currentEnd = currentInterval[1]
		nextStart,nextEnd = nextInterval
		
		if currentEnd >= nextStart:
			currentInterval[1] = max(currentEnd,nextEnd)
		else:
			currentInterval = nextInterval
			answer.append(currentInterval)
	return answer
			
	
