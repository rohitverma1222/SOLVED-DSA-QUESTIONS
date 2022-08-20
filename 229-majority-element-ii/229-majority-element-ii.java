class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer first=null;
        int fCount=0;
        Integer sec=null;
        int sCount=0;

        for(int i:nums)
        {
            if(first!=null && first==i)
            {
                fCount++;
            }
            else if(sec!=null && sec==i)
            {
                sCount++;
            }
            else if(fCount==0)
            {
                first=i;
                fCount++;
            }
            else if(sCount==0)
            {
                sec=i;
                sCount++;
            }
            else{
                fCount--;
                sCount--;
            }
        }

        List<Integer> li=new ArrayList<>();
        int c=0;
        for(int i:nums)
        {
            if(first!=null && first==i)
                c++;
        }
        if(c>nums.length/3)
            li.add(first);
        c=0;
        for(int i:nums)
        {
            if(sec!=null && sec==i)
                c++;
        }
        if(c>nums.length/3)
            li.add(sec);

        return li;
    }
}