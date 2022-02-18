class Solution:
    def climbStairs(self, n: int) -> int:
        stairs = [0 for i in range(n+1)]
        stairs[1] = 1
        if 1<n:
            stairs[2]=2
        if len(stairs)<=2:
            return stairs[n]
        for i in range(3,n+1):
            stairs[i] = stairs[i-1] + stairs[i-2]
        return stairs[n]
        
        

p = Solution()
input = 5
print(p.climbStairs(input))