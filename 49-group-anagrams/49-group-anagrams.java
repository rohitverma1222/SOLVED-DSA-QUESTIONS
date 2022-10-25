class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hs=new HashMap<>();
        for(String str:strs)
        {
            String s=check(str);
            if(hs.containsKey(s))
            {
                hs.get(s).add(str);
            }
            else{
                List<String> li=new ArrayList<>();
                li.add(str);
                hs.put(s,li);
            }
        }
        List<List<String>> li=new ArrayList<>();
        for(List<String> l:hs.values())
        {
            li.add(new ArrayList<>(l));
        }
        return li;
    }
    public String check(String str)
    {
        int []arr=new int[26];
        for(char ch:str.toCharArray())
            arr[ch-'a']++;
        
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<26;i++)
        {
            while(arr[i]-->0)
                ans.append(i+'a');
        }
        return ans.toString();
    }
}