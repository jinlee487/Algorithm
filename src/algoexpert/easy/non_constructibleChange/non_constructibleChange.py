def nonConstructibleChange(coins):
    # Write your code here.
	coins.sort()
	s = 0
	for coin in coins:
		if s + 1 < coin:
			return s+1
		s += coin
    return s + 1
