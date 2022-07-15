class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-1;i>0;i--)
        {
            if(nums[i-1]<nums[i])
            {
                idx=i-1;
                break;
            }
        }
        // System.out.println(nums[idx]);
        if(idx==-1)
        {
            revers(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>idx;i--)
        {
            if(nums[idx]<nums[i])
            {
                swap(nums,idx,i);
                break;
            }
        }
        int left=idx+1;
        int right=nums.length-1;
        revers(nums,left,right);
    }
    public void swap(int []arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void revers(int []arr,int left,int right)
    {
        while(left<right)
        {
            swap(arr,left,right);
            left++;
            right--;
        }
    }
    public void display(int []arr)
    {
        for(int i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
}