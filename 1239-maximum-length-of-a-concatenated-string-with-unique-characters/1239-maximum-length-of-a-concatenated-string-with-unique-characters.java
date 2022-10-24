class Solution {
    int max=0;
    public int maxLength(List<String> arr) {
        List<String> ans=new ArrayList<>();
        for(String str:arr)
        {
            HashSet<Character> hs=new HashSet<>();
            for(char ch:str.toCharArray())
            {
                hs.add(ch);
            }
            if(hs.size()==str.length())
                ans.add(str);
        }
        if(ans.size()==0)
            return 0;
        helper(0,ans,new HashSet<>());
        return max;
    }
    public void helper(int i,List<String> arr,HashSet<Character> hs)
    {
        if(i>=arr.size())
        {
            max=Math.max(max,hs.size());
            return;
        }
        boolean flag=true;
        
        for(char ch:arr.get(i).toCharArray())
        {
            if(hs.contains(ch))
                flag=false;
        }
        HashSet<Character> newhs=new HashSet<>();
        for(char ch:hs)
            newhs.add(ch);
        
        if(flag)
        {
            for(char ch:arr.get(i).toCharArray())
                newhs.add(ch);
            helper(i+1,arr,newhs);
        }
            helper(i+1,arr,hs);
    }
}