from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        answer = 0
        i = 0
        j = len(height)-1
        while i != j:
            leftHeight = height[i]
            rightHeight = height[j]
            currentArea =  min(leftHeight,rightHeight)*(j-i)  
            if answer <= currentArea:
                answer = currentArea
            if leftHeight < rightHeight:
                i+=1
            else:
                j-=1
        return answer

        
p = Solution()
height = [1,1]
print(p.maxArea(height))