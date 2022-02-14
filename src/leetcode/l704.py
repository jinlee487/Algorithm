def search(nums, target):
    start = 0
    end = len(nums)-1
    while start<=end:
        mid = (start + end)//2
        print(mid)
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            end = mid-1
        else:
            start = mid+1
    return -1

nums = [-1,0,3,5,9,12]
target = 5
print(search(nums,target))