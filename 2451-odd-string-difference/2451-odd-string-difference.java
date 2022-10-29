class Solution {
    public String oddString(String[] words) {
        HashMap<List<Integer>,List<String>> hs=new HashMap<>();
        int i=0;
        for(String str:words)
        {
            List<Integer> ans=check(str);
            if(hs.containsKey(ans))
            {
                hs.get(ans).add(str);
            }
            else{
                List<String> li=new ArrayList<>();
                li.add(str);
                hs.put(ans,li);
            }
        }
        String ret="";
        for(List<Integer> li:hs.keySet())
        {
            if(hs.get(li).size()==1)
            {
                return hs.get(li).get(0);
            }
        }
        return ret;
    }
    public List<Integer> check(String str)
    {
        List<Integer> li=new ArrayList<>();
        for(int i=1;i<str.length();i++)
        {
            int ch=str.charAt(i)-'a';
            int chj=str.charAt(i-1)-'a';
            li.add(ch-chj);
        }
        return li;
    }
}