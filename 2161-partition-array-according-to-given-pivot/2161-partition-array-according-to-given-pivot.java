class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int i=0;
        int p=0;
        
        for(int n:nums)
        {
            if(n<pivot)
            {
                ans[i++]=n;
            }
            else if(n==pivot){
                p++;
            }
        }
        
        while(p-->0)
            ans[i++]=pivot;
        
        for(int n:nums)
        {
            if(n>pivot)
                ans[i++]=n;
        }
        
        return ans;
    }
}