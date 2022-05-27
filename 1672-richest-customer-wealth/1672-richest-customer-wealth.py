class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        maximum=0
        for acc in accounts:
            curr=sum(acc)
            maximum=max(maximum,curr)
        return maximum
        