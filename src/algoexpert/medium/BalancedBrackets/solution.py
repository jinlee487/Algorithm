def balancedBrackets(string):
    # Write your code here.
	opening = '({['
	closing = '}])'
	match = {"}":"{","]":"[",")":"("}
	stack = []
	for char in string:
		if char in opening:
			stack.append(char)
		elif char in closing:
			if len(stack) == 0:
				return False
			if match[char] != stack.pop():
				return False
	return len(stack) == 0
