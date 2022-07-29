class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans=new LinkedList<>();
        
        HashMap<Character,Integer> hs=sim(pattern);
        
        for(int i=0;i<words.length;i++)
        {
            HashMap<Character,Integer> g=sim(words[i]);
            if(hs.size()==g.size())
            {
                boolean does=true;
                for(int s:hs.values())
                {
                    if(!g.containsValue(s))
                    {
                        does=false;
                    }
                }
                if(does)
                    ans.add(words[i]);
            }
        }
        return ans;
    }
    public HashMap<Character,Integer> sim(String pattern)
    {
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
            char ch=pattern.charAt(i);
            if(hs.containsKey(ch))
            {
                int val=hs.get(ch);
                hs.put(ch,val+i);
            }
            else
            {
                hs.put(ch,i);
            }
        }
        return hs;
    }
}



















