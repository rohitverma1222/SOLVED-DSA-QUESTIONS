class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int val=nums[nums.length/2];
        
        int sum=0;
        for(int n:nums)
        {
            sum+=Math.abs(n-val);
        }
        return sum;
    }
}