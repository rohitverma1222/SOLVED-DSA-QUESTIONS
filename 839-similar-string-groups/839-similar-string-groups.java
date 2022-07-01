class Solution {
    HashMap<String,String> parent=new HashMap<>();
    HashMap<String,Integer> rank=new HashMap<>();
    public int numSimilarGroups(String[] strs) {
        for(String str:strs)
        {
            parent.put(str,str);
            rank.put(str,0);
        }

        for(int i=0;i<strs.length;i++)
        {
            for(int j=i+1;j<strs.length;j++)
            {
                String f=strs[i];
                String s=strs[j];
                if(isSim(f,s))
                {
                    String li=find(f);
                    String lj=find(s);
                    if(li.equals(lj)==false)
                    {
                        union(li,lj);
                    }
                }
            }
        }
        int c=0;
        for(String str:parent.keySet())
        {
            if(parent.get(str).equals(str))
                c++;
        }
        return c;

    }
    public boolean isSim(String x,String y)
    {
        int res=0;
        for(int i=0;i<x.length();i++)
        {
            if(x.charAt(i)!=y.charAt(i))
                res++;
        }
        return res==2;
    }

    public String find(String x)
    {
        if(parent.get(x).equals(x))
            return x;
        String ans=find(parent.get(x));

        parent.put(x,ans);
        return ans;
    }
    public void union(String u,String v)
    {
        if(rank.get(u)<rank.get(v))
            parent.put(u,v);
        else if(rank.get(v)<rank.get(u))
            parent.put(v,u);
        else{
            parent.put(u,v);
            rank.put(v,rank.get(v)+1);
        }
    }
}