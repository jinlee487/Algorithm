def sunsetViews(buildings, direction):
    # Write your code here.
    answer = []
    if direction == "EAST": 
        right(answer,buildings)
    else:
        left(answer,buildings)
    return answer
def left(answer,buildings):
	max = float("-inf")
	for i in range(len(buildings)):
		if buildings[i] <= max:
			continue
		max = buildings[i]
		answer.append(i)
def right(answer,buildings):
	max = float("-inf")
	for i in range(len(buildings)-1,-1,-1):
		if buildings[i] <= max:
			continue
		max = buildings[i]
		answer.append(i)	
	answer.reverse()

def sunsetViews(buildings, direction):
    # Write your code here.
	answer = []
	start = 0 if direction == "EAST" else len(buildings) - 1
	step = 1 if direction == "EAST" else -1
	idx = start
	while idx >= 0 and idx < len(buildings):
		current = buildings[idx]
		while len(answer) > 0 and buildings[answer[len(answer)-1]]<=current:
			answer.pop()
		answer.append(idx)
		idx += step
	if direction == "WEST":
		return answer[::-1]
	return answer
		
