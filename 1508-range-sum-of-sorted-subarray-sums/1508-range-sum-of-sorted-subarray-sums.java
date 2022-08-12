class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> li=new ArrayList<>();
        // for(int i:nums)
        // {
        //     li.add(i);
        // }

        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum+=nums[j];
                li.add(sum);
            }
        }
        Collections.sort(li);
        // System.out.println(li);
        long sum=0;
        long mod=1000000007;
        for(int i=left-1;i<right;i++)
        {
            sum=(sum+li.get(i))%mod;
        }

        return (int)sum;
    }
}