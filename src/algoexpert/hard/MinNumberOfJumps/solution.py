def minNumberOfJumps(array):
    # Write your code here.
    dp = [float("inf") for _ in array]
    dp[0] = 0
    for i in range(len(array)):
        for j in range(1,array[i]+1):
            if len(array)<=i+j: 
                break
            dp[i+j] = min(dp[i]+1,dp[i+j])
    return dp[-1]
def minNumberOfJumps(array):
    # Write your code here.
    if len(array)<=0: 
        return 0
    dp = [float("inf") for _ in array]
    dp[0] = 0
    for i in range(1,len(array)):
        for j in range(0,i):
            if array[j] >= i-j:
                dp[i] = min(dp[j]+1,dp[i])
    return dp[-1]
def minNumberOfJumps(array):
    # Write your code here.
    if len(array) <= 1: 
        return 0
    dp = 0
    maxReach = array[0]
    steps = array[0]
    for i in range(1,len(array)-1):
        maxReach = max(array[i]+i,maxReach)
        steps -= 1
        if steps == 0:
            dp += 1
            steps = maxReach - i
    return dp +1
