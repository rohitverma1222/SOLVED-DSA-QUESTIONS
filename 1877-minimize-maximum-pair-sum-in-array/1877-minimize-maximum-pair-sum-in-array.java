class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int max=0;
        
        while(left<right)
        {
            max=Math.max(max,nums[left]+nums[right]);
            left++;
            right--;
        }
        return max;
    }
}
// 234456
//2335