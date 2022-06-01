class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ans=[]
        sum=0
        for val in nums:
            sum+=val
            ans.append(sum);
        
        return ans