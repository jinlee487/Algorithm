# https://leetcode.com/problems/two-sum/
# Two Sum
# Solved!
# 08/15/2021 21:19	Accepted	52 ms	15.1 MB	python

class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i in range(len(nums)):
            if nums[i] in d:
                d[nums[i]].append(i)
            else: 
                d[nums[i]] = [i]
        for k in d:
            a = d[k].pop()
            b = target - nums[a]
            if b in d:
                if d[b]:
                    return [a,d[b].pop()]
            else:
                d[k].append(a)

# best solution 
# 08/15/2021 21:24	Accepted	40 ms	14.4 MB	python
# class Solution(object):
#     def twoSum(self, nums, target):

#         hashMap={nums[idx]:idx for idx in range(len(nums))} # {num : index}
        
#         for idx in range(len(nums)):
#             complement=target-nums[idx]
#             if hashMap.get(complement,False) and hashMap.get(complement,False) != idx:
#                 return [idx,hashMap.get(complement)]              
            
solution = Solution()
nums = [2,7,11,15]
target = 9
print(solution.twoSum(nums,target))
        
        
        