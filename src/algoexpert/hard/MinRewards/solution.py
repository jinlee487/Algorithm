def minRewards(scores):
    # Write your code here.
	arr = [1 for _ in scores]
	for i in range(1, len(scores)):
		j = i - 1
		if scores[j] < scores[j+1]:
			arr[j+1] = arr[j] + 1
		else:
			while 0<=j and scores[j+1] < scores[j]:
				arr[j] = max(arr[j],arr[j+1]+1)
				j -= 1
	return sum(arr)
def minRewards(scores):
    # Write your code here.
    arr = [1 for _ in scores]
    minarray = []
    for i in range(len(scores)):
        if len(scores) == 1:
            minarray.append(i)
            break
        if i == 0 and scores[i] < scores[i+1]:
            minarray.append(i)
        elif i == len(scores) -1 and scores[i] < scores[i-1]:
            minarray.append(i)
        elif 0 < i and i < len(scores)-1 and scores[i] < scores[i+1] and scores[i] < scores[i-1]:
            minarray.append(i)
    for index in minarray:
        left = index-1
        right = index+1
        while 0<=left and scores[left+1] < scores[left]:
            arr[left] = max(arr[left],arr[left+1] + 1)
            left -= 1
        while right<=len(scores)-1 and scores[right-1] < scores[right]:
            arr[right] = max(arr[right],arr[right-1] + 1)
            right += 1
    print(arr)
    return sum(arr)
def minRewards(scores):
    # Write your code here.
	arr = [1 for _ in scores] 
	for i in range(1, len(scores)):
		if scores[i-1] < scores[i]:
			arr[i] = arr[i-1] + 1
	for i in reversed(range(len(scores)-1)):
		if scores[i+1] < scores[i]:
			arr[i] = max(arr[i], arr[i+1]+1)
	return sum(arr)
    
