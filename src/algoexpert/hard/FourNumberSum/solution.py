def fourNumberSum(array, targetSum):
    # Write your code here.
	answer = []
	for i in range(len(array)):
		for j in range(i+1,len(array)):
			for k in range(j+1,len(array)):
				for l in range(k+1,len(array)):
					if array[i] + array[j] + array[k] + array[l] == targetSum:
						answer.append([array[i], array[j], array[k], array[l]])
	return answer

def fourNumberSum(array, targetSum):
    # Write your code here.
	answer = [] 
	dic = {}
	for i in range(1, len(array)-1):
		for j in range(i+1,len(array)):
			key = array[i] + array[j]
			if targetSum - key in dic:
				for pairs in dic[targetSum - key]:
					answer.append([array[i],array[j],pairs[0],pairs[1]])
		for j in range(0,i):
			key = array[i] + array[j]
			if key not in dic:
				dic[key] = []
			dic[key].append([array[i],array[j]])
    return answer
