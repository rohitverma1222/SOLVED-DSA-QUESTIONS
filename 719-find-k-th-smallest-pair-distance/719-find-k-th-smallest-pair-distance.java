class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0;
        for(int i=1;i<nums.length-1;i++)
        {
            l=Math.min(l,nums[i+1]-nums[i]);
        }
        int n=nums.length;
        int h=nums[n-1]-nums[0];

        while(l<h)
        {
            int mid=l+(h-l)/2;
            int j=0;
            int c=0;
            for(int i=0;i<nums.length;i++)
            {
                while(j<nums.length && nums[j]-nums[i]<=mid)
                    j++;

                c+=(j-i-1);
            }

            if(c<k)
                l=mid+1;
            else
                h=mid;
        }
        return l;
    }
}