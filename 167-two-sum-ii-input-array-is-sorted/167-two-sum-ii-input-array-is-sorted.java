class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        // hs.put()
        for(int i=0;i<numbers.length;i++)
        {
            hs.put(numbers[i],i);
        }
        int ans[]=new int[2];
        for(int i=0;i<numbers.length;i++)
        {
            int val=numbers[i];
            if(hs.containsKey(target-val))
            {
                int idx=hs.get(target-val);
                ans[0]=i+1;
                ans[1]=idx+1;
                return ans;
            }
        }
        return new int[0];
    }
}