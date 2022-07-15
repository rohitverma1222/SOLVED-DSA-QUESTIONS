class Solution {
    public int majorityElement(int[] nums) {
       int c=1;
        int val=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(c==0)
                val=nums[i];
            
            c+=(val==nums[i]?+1:-1);
        }
        return val;
    }
}