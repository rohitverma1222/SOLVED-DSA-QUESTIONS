class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> mq=new LinkedList<>();
        mq.add(start);
        Set<String> hs1=new HashSet<>();
        for(String str:bank)
            hs1.add(str);
        
        Set<String> hs2=new HashSet<>();
        hs2.add(start);
        char arr[]={'A','C','G','T'};
        int st=0;
        while(mq.size()!=0)
        {
            int size=mq.size();
            for(int j=0;j<size;j++)
            {
                // System.out.println(st);
                String rem=mq.remove();
                if(rem.equals(end))
                    return st;
                for(char ch:arr)
                {
                    for(int i=0;i<rem.length();i++)
                    {
                        String ans=rem.substring(0,i)+ch+rem.substring(i+1);
                        if(hs2.contains(ans)==false && hs1.contains(ans))
                        {
                            mq.add(ans);
                            hs2.add(ans);
                            hs1.add(ans);
                        }
                    }
                }
            }
            st++;
        }
        return -1;    
    }
}