class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // return 0;
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                int curr=nums[i]+nums[j]+nums[k];
                if(nums[i]+nums[j]+nums[k]==target)
                    return target;
                if(Math.abs(curr-target)<Math.abs(target-ans))
                {
                    ans=curr;
                }
                else if(nums[i]+nums[j]+nums[k]<target)
                {
                    j++;
                }
                else
                    k--;
            }
        }
        return ans;
    }
}