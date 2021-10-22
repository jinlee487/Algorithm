def hasSingleCycle(array):
    # Write your code here.
	visited = 0 
	current = 0
	while visited < len(array):
		if visited > 0 and current == 0:
			return False
		visited += 1
		current = getIdx(current,array)
	return current == 0
def getIdx(current, array):
	jump = array[current]
	idx = (current + jump) % len(array)
	return idx if idx >= 0 else idx+len(array)
    pass
