def minNumberOfCoinsForChange(n, denoms):
    # Write your code here.
	dp = [float("inf") for i in range(n+1)] 
	dp[0] = 0
	for denom in denoms:
		for i in range(len(dp)):
			if denom <= i:
				dp[i] = min(dp[i],dp[i-denom]+1)
	return -1 if dp[i] == float("inf") else dp[i]
