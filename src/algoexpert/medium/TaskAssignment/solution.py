def taskAssignment(k, tasks):
    # Write your code here.
	answer = [] 
	dic = {}
	for i in range(len(tasks)):
		if tasks[i] in dic:
			dic[tasks[i]].append(i)
		else:
			dic[tasks[i]] = [i]
	tasks = sorted(tasks)
	for i in range(k):
		answer.append([dic[tasks[i]].pop(0)])
	for i in range(k):
		answer[i].append(dic[tasks.pop()].pop())
    return answer
