class Solution {
    public boolean increasingTriplet(int[] nums) {
        int []tails=new int[nums.length];

        tails[0]=nums[0];
        int len=1;

        for(int i=1;i<nums.length;i++)
        {
            if(tails[len-1]<nums[i])
            {
                len++;
                tails[len-1]=nums[i];
            }
            else{
                int idx=Arrays.binarySearch(tails,0,len-1,nums[i]);

                if(idx<0)
                {
                    idx=-idx;
                    idx-=1;
                }
                tails[idx]=nums[i];
            }
        }
        return len>2;
    }
}