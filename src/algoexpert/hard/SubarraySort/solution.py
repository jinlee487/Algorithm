def subarraySort(array):
    # Write your code here.
	maximum = float("-inf")
	minimum = float("inf")
	for i in range(len(array)):
		num = array[i]
		if check(i,num,array):
			maximum = max(maximum,num)
			minimum = min(minimum,num)
	if minimum == float("inf"):
		return [-1,-1]
	start = 0
	end = len(array)-1
	while minimum >= array[start]: 
		start += 1
	while maximum <= array[end]: 
		end -= 1
	return [start,end]
		
def check(i,num,array):
	if i==0:
		return num > array[i+1]
	if i == len(array) -1:
		return num < array[i-1]
	return num > array[i+1] or num < array[i-1]

def subarraySort(array):
    # Write your code here.
    maximum = float("-inf")
    end = float("-inf")
    start = float("inf")
    for i in range(len(array)):
        if maximum < array[i]:
            maximum = array[i]
            continue
        for j in reversed(range(i)):
            if array[j] <= array[i]:
                break
            start = min(start,j)
        end = max(end, i)
    start = -1 if start == float("inf") else start
    end = -1 if start == -1 else end
    return [start,end]

