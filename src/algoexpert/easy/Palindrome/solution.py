def isPalindrome(string):
    # Write your code here.
	reverse = ""
	for i in range(len(string)-1,-1,-1):
		reverse += string[i]
	return True if reverse == string else False

def isPalindrome(string):
    # Write your code here.
	return isPalindromeHelper(string, 0)
def isPalindromeHelper(string, i):
	j = len(string) - 1 - i
	return True if i >= j else string[i] == string[j] and isPalindromeHelper(string, i + 1)

def isPalindrome(string):
    # Write your code here.
	for i in range(len(string)):
		if string[i] != string[len(string) - 1 - i]:
			return False
	return True
    
