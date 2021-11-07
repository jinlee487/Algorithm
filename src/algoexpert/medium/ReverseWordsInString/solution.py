def reverseWordsInString(string):
    # Write your code here.
	answer = [c for c in string]
	reverse(answer, 0, len(answer) -1)
	start = 0 
	while start < len(answer):
		end = start
		while(end < len(answer) and answer[end] != " "):
			end += 1
		reverse(answer, start, end-1)
		start = end + 1
    return "".join(answer)
def reverse(answer,start,end):
	while start<end:
		answer[start], answer[end] = answer[end], answer[start]
		start += 1
		end -= 1
def reverseWordsInString(string):
    # Write your code here.
	answer = [c for c in string]
	reverse(answer, 0, len(answer) -1)
	start = 0 
	while start < len(answer):
		end = start
		while(end < len(answer) and answer[end] != " "):
			end += 1
		reverse(answer, start, end-1)
		start = end + 1
    return "".join(answer)
def reverse(answer,start,end):
	while start<end:
		answer[start], answer[end] = answer[end], answer[start]
		start += 1
		end -= 1
