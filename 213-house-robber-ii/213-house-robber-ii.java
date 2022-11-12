class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(robb(nums,0,nums.length-2),robb(nums,1,nums.length-1));
    }
    public int robb(int []nums,int l,int h)
    {
        int inc=0;
        int ex=0;
        for(int i=l;i<=h;i++)
        {
            int ninc=ex+nums[i];
            int nex=Math.max(ex,inc);
            
            inc=ninc;
            ex=nex;
        }
        return Math.max(inc,ex);
    }
}