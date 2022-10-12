class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums)
            hs.add(i);
        
        int sum=0;
        for(int i:hs)
        {
            int len=0;
            if(!hs.contains(i-1))
            {
                int val=i;
                while(hs.contains(val))
                {
                    len++;
                    val++;
                }
                sum=Math.max(len,sum);
            }
            
        }
        return sum;
    }
}