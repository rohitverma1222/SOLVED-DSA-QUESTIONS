class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> li=new ArrayList<>();
        int t1=bound(x,bound);
        int t2=bound(y,bound);
        HashSet<Integer> hs=new HashSet<>();
        if(bound<=1)
            return li;
        for(int i=0;i<=t1;i++)
        {
            for(int j=0;j<=t2;j++)
            {
                int val=(int)Math.pow(x,i)+(int)Math.pow(y,j);
                if(val<=bound && val>=0)
                    hs.add(val);
            }
        }
        for(int val:hs)
            li.add(val);
        return li;
    }
    public int bound(int x,int bound)
    {
        int i=0;
        while(x<=bound)
        {
            x+=x;
            i++;
        }
        return i;
    }
}