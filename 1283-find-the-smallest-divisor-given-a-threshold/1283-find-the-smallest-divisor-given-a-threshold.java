class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int h=(int)Math.pow(10,6);
        int l=1;

        while(l<h)
        {
            int mid=(l+h)/2;
            int res=0;
            int sum=0;
            for(int i=0;i<nums.length;i++)
            {
                res+=(nums[i]+mid-1)/mid;
            }

            if(res<=threshold)
            {
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}