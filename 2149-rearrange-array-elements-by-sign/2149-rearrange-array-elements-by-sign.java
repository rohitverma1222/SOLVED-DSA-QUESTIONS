class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int []even=new int[n/2];
        int odd[]=new int[n/2];

        int i=0;
        int j=0;

        for(int k=0;k<n;k++)
        {
            if(nums[k]>0)
                even[i++]=nums[k];
            else
                odd[j++]=nums[k];
        }
        // for(int k:even)
        //     System.out.println(k);

        int []ans=new int[n];
        i=0;
        j=0;
        for(int k=0;k<n;k++)
        {
            if(k%2==0)
            {
                ans[k]=even[i++];
            }
            else{
                ans[k]=odd[j++];
            }
        }
        return ans;
    }
}