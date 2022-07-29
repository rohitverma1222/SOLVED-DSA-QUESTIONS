class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int l=get(nums,firstLen,secondLen);
        int r=get(nums,secondLen,firstLen);

        return Math.max(l,r);
    }

    public int get(int []nums,int f,int s)
    {
        int n=nums.length;
        int left[]=new int[n];
        int sum=0;
        int lmax=0;
        for(int i=0;i<left.length;i++)
        {
            sum+=nums[i];
            if(i-(f-1)>0)
            {
                sum-=nums[i-f];
            }
            lmax=Math.max(lmax,sum);
            left[i]=lmax;
        }
        int []right=new int[n];
        sum=0;
        lmax=0;
        for(int i=n-1;i>=0;i--)
        {
            sum+=nums[i];
            if(i+s<n)
                sum-=nums[i+s];
            lmax=Math.max(lmax,sum);
            right[i]=lmax;
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<left.length-1;i++)
        {
            max=Math.max(max,left[i]+right[i+1]);
            // System.out.println(left[i]+" "+right[i]);
            
        }
        return max;
    }
}