def twoSum(numbers, target):
    """
    :type numbers: List[int]
    :type target: int
    :rtype: List[int]
    """
#         binary search
    start = 0 
    end = len(numbers)-1
    while start < end:
        temp = numbers[start] + numbers[end]
        if temp == target:
            return [start+1, end+1]
        elif temp < target:
            start += 1
        elif temp > target:
            end -= 1
                