def largestRange(array):
    # Write your code here.
    answer = []
    longestLength = 0
    dic = {}
    for v in array:
        dic[v] = True
    for v in array:
        if not dic[v]:
            continue
        dic[v] = False
        currentLength = 1
        left = v - 1
        right = v + 1
        while left in dic:
            dic[left] = False
            currentLength += 1
            left -= 1
        while right in dic:
            dic[right] = False
            currentLength += 1
            right += 1
        if currentLength > longestLength:
            longestLength = currentLength
            answer = [left + 1, right -1]
    return answer
