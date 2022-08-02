class Solution {
    HashSet<String> hs=new HashSet<>();
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0,new ArrayList<>());
        return ans;
    }
    public void helper(int nums[],int idx,List<Integer> li)
    {
        if(idx>=nums.length)
        {
            String str="";
            for(int i:li)
            {
                str+=i;
            }
            if(!hs.contains(str))
            {
                hs.add(str);
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        li.add(nums[idx]);
        helper(nums,idx+1,li);
        li.remove(li.size()-1);
        helper(nums,idx+1,li);
    }
}