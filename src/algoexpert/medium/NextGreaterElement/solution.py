def nextGreaterElement(array):
    # Write your code here.
    answer = [-1] * len(array)
    stack = [] 
    for i in range(2*len(array)):
        idx = i % len(array)
        while len(stack ) > 0 and array[stack[len(stack)-1]] < array[idx]:
            answer[stack.pop()] = array[idx]
        stack.append(idx)
    return answer
