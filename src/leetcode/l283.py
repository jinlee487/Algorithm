def moveZeroes(nums):
    """
    :type nums: List[int]
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    if len(nums) <= 0:
        return nums
    lastZero = -1
    index = 0
    while index<len(nums):
        print(index)
        print(lastZero)
        print(nums)
        if nums[index] == 0 and lastZero == -1: 
            lastZero = index
        elif nums[index] != 0 and lastZero != -1:
            swap(nums,lastZero,index)
            lastZero += 1
        index+=1
    return nums
def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp
        
nums = [0,1,0,3,12]
print(moveZeroes(nums))       