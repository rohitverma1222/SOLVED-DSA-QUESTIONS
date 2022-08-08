class Solution {
    public int triangularSum(int[] nums) {
        if(nums.length==1)
            return nums[0];
        List<Integer> li=new ArrayList<>();
        for(int i:nums)
        {
            li.add(i);
        }
        while(li.size()!=1)
        {
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<li.size()-1;i++)
            {
                ans.add((li.get(i)+li.get(i+1))%10);
            }
            li=ans;
        }
        return li.get(0);
    }
}