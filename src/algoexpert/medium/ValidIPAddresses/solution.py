def validIPAddresses(string):
    # Write your code here.
	answer = []
	for i in range(1,min(len(string),4)):
		current = ["","","",""]
		current[0] = string[:i]
		if not check(current[0]):
			continue
		for j in range(i+1,i+min(len(string)-i,4)):
			current[1] = string[i:j]
			if not check(current[1]):
				continue
			for k in range(j+1,j+min(len(string)-j,4)):
				current[2] = string[j:k]
				current[3] = string[k:]
				if check(current[2]) and check(current[3]):
					answer.append(".".join(current))
    return answer
								 
def check(string):
	num = int(string)
	if num>255:
		return False
	return len(string) == len(str(num))
								 
			