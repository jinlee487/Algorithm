def shortenPath(path):
    # Write your code here.
	stack = []
	isRelative = False
	paths = path.split("/")
	if len(paths)==0:
		return "/"
	start = 0
	if paths[0] == "":
		isRelative = True
		start = 1
	for i in range(start, len(paths)):
		p = paths[i]
		if p == "" or p == ".":
			continue
		elif p == "..":
			if len(stack) != 0:
				if stack[len(stack)-1] == "..":
					stack.append(p)
				else:
					stack.pop()
			else:
				if isRelative is False: 
					stack.append(p)
		else:
			stack.append(p)
	if isRelative is True:
		return "/" + "/".join(stack)
	else:
		return "/".join(stack)
				
