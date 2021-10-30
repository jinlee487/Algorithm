def validStartingCity(distances, fuel, mpg):
    # Write your code here.

	for i in range(len(distances)):
		count = 0
		current = 0
		miles = 0
		for j in range(i,len(distances)+i+1): 
			if j == len(distances)+i: 
				return i
			if len(distances)<=j: 
				j -= len(distances)
			miles += fuel[j]*mpg-distances[j]
			if miles < 0:
				break;	
    return -1
def validStartingCity(distances, fuel, mpg):
    # Write your code here.
	miles = 0
	answer = 0
	start = 0
	for i in range(1,len(distances)):
		miles += fuel[i-1]*mpg-distances[i-1]
		if miles < start:
			start = miles 
			answer = i
    return answer
