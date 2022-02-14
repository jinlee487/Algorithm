
# O(n^2) O(1)
# def rotate(nums, k):
#     """
#     :type nums: List[int]
#     :type k: int
#     :rtype: None Do not return anything, modify nums in-place instead.
#     """
#     for _ in range(k):
#         current = nums[0]
#         for i in range(len(nums)):
#             j = (i + 1) % len(nums)
#             temp = nums[j]
#             nums[j] = current
#             current = temp
#     return nums

# O(n) O(1)
def rotate(nums, k):
    """
    :type nums: List[int]
    :type k: int
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    if len(nums) <= 1:
        return nums
    k = k%len(nums)
    reverse(nums, 0, len(nums)-1)
    reverse(nums,0,k-1)
    reverse(nums,k,len(nums)-1)
    return nums
def reverse(nums, i, j):
    while i<j:
        swap(nums,i,j)
        i+=1
        j-=1
    
def swap (nums, i ,j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

# O(n) O(n)
# def rotate(nums, k):
#     """
#     :type nums: List[int]
#     :type k: int
#     :rtype: None Do not return anything, modify nums in-place instead.
#     """
#     temp = nums[:]
#     for i in range(len(nums)):
#         j = (i + k)%len(nums)
#         nums[j] = temp[i]
#     return nums        


nums = [1,2,3,4,5,6,7]
k = 3
result = rotate(nums,k)
answer = [5,6,7,1,2,3,4]
if result != answer:
    print("not correct")
    print(answer)
    print(result)
else:
    print(result)



