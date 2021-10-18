def numberOfWaysToMakeChange(n, denoms):
    # Write your code here.
	answer = [0 for i in range(n+1)]
	answer[0] = 1
	for denom in denoms:
		for a in range(1,n+1):
			if denom <= a:
				answer[a] += answer[a-denom]
	return answer[n]
