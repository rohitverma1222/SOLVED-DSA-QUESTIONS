class Solution:
    def getMaximumConsecutive(self, coins: List[int]) -> int:
        max=1
        for i in sorted(coins):
            if i>max:
                break
            max+=i
        return max