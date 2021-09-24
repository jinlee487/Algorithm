
def getNthFib(n):
    # Write your code here.
	if n == 1: 
		return 0
	if n == 2: 
		return 1
	return getNthFib(n-1) + getNthFib(n-2) 
    


def getNthFib(n , memoize = {1 : 0, 2 : 1}):
    # Write your code here.
	if n in memoize:
		return memoize[n]
	memoize[n] = getNthFib(n - 1, memoize) + getNthFib(n-2, memoize)
	return memoize[n]
	


def getNthFib(n):
    # Write your code here.
	firstTwo = [0,1]
	count = 3
	while count <= n:
		nextFib = firstTwo[0] + firstTwo[1]
		firstTwo[0] = firstTwo[1]
		firstTwo[1] = nextFib
		count += 1
	return firstTwo[1] if n > 1 else firstTwo[0]
