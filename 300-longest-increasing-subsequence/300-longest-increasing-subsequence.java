class Solution {
    public int lengthOfLIS(int[] nums) {
        int []tail=new int[nums.length];
        
        tail[0]=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++)
        {
            if(tail[len-1]<nums[i])
            {
                len++;
                tail[len-1]=nums[i];
            }
            else{
                int idx=Arrays.binarySearch(tail,0,len-1,nums[i]);
                if(idx<0)
                {
                    idx=-idx;
                    idx=idx-1;
                }
                    tail[idx]=nums[i];
            }
        }
        return len;
    }
}