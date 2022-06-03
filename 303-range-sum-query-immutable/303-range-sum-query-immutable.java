class NumArray {
    int ans[]={};
    public NumArray(int[] nums) {
        ans=new int[nums.length+1];
        for(int i=1;i<nums.length+1;i++)
        {
            ans[i]=ans[i-1]+nums[i-1];
            // System.out.println(ans[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        return ans[right+1]-ans[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */