def sortStack(stack):
    # Write your code here.
	if len(stack) == 0: 
		return stack
	current = stack.pop()
	sortStack(stack)
	while len(stack) != 0 and current < stack[len(stack)-1]:
		nextNumber = stack.pop()
		stack.append(current)
		current = nextNumber
		sortStack(stack)
	stack.append(current)
    return stack
def sortStack(stack):
    # Write your code here.
	if len(stack) == 0:
		return stack
	current = stack.pop()
	sortStack(stack)
	sortStackHelper(stack,current)
    return stack
def sortStackHelper(stack,value):
	if len(stack) == 0 or stack[len(stack)-1] <= value:
		stack.append(value)
		return stack
	current = stack.pop()
	sortStackHelper(stack,value)
	stack.append(current)
	
