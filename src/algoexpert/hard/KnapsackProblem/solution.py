def knapsackProblem(items, capacity):
    # Write your code here.
	dp = [[0 for x in range(0, capacity + 1)] for y in range(0,len(items)+1)]
	for i in range(1,len(items)+1):
		currentWeight = items[i-1][1]
		currentValue = items[i-1][0]
		for c in range(0,capacity+1):
			if currentWeight > c:
				dp[i][c] = dp[i-1][c]
			else:
				dp[i][c] = max(dp[i-1][c],dp[i-1][c-currentWeight]+currentValue);
	return [dp[-1][-1],knapsackProblemHelper(dp,items)]
def knapsackProblemHelper(dp,items):
	sequence = []
	i = len(dp)-1
	c = len(dp[0])-1
	while i>0:
		if dp[i][c] == dp[i-1][c]: 
			i-=1
		else:
			sequence.append(i-1)
			c-= items[i-1][1]
			i -=1
		if c==0:
			break
	return list(reversed(sequence))
    # return [
    #   10, // total value
    #   [1, 2], // item indices
    # ]
    pass
