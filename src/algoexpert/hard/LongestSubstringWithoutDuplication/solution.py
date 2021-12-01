def longestSubstringWithoutDuplication(string):
    # Write your code here.
	dic = {}
	answer = [0,1]
	start = 0
	for i, char in enumerate(string):
		if char in dic:
			start = max(start,dic[char]+1)
		if answer[1]-answer[0] < i+1-start:
			answer = [start,i+1]
		dic[char] = i
	return string[answer[0] : answer[1]]
    
