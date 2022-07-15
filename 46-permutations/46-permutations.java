class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> an=new LinkedList();
        int n=fact(nums.length);
        for(int k=0;k<n;k++)
        {
            List<Integer> li=new LinkedList<>();
            int ans[]=perm(nums);
            for(int i=0;i<ans.length;i++)
            {
                li.add(ans[i]);
            }
            an.add(li);
        }
        return an;
    }
    public int fact(int n)
    {
        if(n==0|| n==1)
            return n;
        return n*fact(n-1);
    }
    public int[] perm(int[] nums) {
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
            return nums;
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
        return nums;
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
}