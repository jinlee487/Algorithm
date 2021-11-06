def longestPalindromicSubstring(string):
    # Write your code here.
	answer = ""
	for i in range(len(string)):
		for j in range(i,len(string)):
			substring = string[i:j+1]
			if len(substring) > len(answer) and isPalindrome(substring):
				answer = substring
	return answer
def isPalindrome(string):
	right = len(string)-1
	left = 0
	while left<right:
		if string[left] != string[right]:
			return False
		left+=1
		right-=1
	return True

def longestPalindromicSubstring(string):
    # Write your code here.
	answer = [0,1]
	for i in range(len(string)):
		odd = getLongestPalindromicSubstring(string,i-1,i+1)
		even = getLongestPalindromicSubstring(string,i-1,i)
		longest = max(odd,even,key=lambda x: x[1] - x[0])
		answer = max(longest,answer, key=lambda x:x[1]-x[0])
    return string[answer[0]:answer[1]]
def getLongestPalindromicSubstring(string,left,right):
	while left >= 0 and right < len(string):
		if string[left] != string[right]:
			break
		left -= 1
		right += 1
	return [left+1,right]
