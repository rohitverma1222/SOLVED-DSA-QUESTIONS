class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> li=new ArrayList<>();
        HashSet<List<Integer>> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int k=j+1;
                int l=nums.length-1;
                while(k<l)
                {
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum==target)
                    {
                        hs.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }
                    else if(sum<target)
                    {
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        for(List<Integer> l:hs)
        {
            li.add(new ArrayList<>(l));
        }
        return li;
    }
}