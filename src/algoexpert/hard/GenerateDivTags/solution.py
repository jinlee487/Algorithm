def generateDivTags(numberOfTags):
	# Write your code here.
	answer = []
	generateDivTagsHelper(answer, "", numberOfTags, numberOfTags)
	return answer

def generateDivTagsHelper(answer, prefix, opening, closing):
	if 0 < opening:
		newPrefix = prefix + "<div>"
		generateDivTagsHelper(answer, newPrefix, opening-1, closing)
	if opening < closing:
		newPrefix = prefix + "</div>"
		generateDivTagsHelper(answer, newPrefix, opening, closing-1)	
	if closing == 0:
		answer.append(prefix)
	return
