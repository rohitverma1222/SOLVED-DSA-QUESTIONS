class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0,s,new ArrayList<>());
        return ans;
    }
    public void helper(int start,String s,List<String> li)
    {
        if(s.length()<=start)
        {
            
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i=start;i<s.length();i++)
        {
            if(palindrome(s,start,i))
            {
                li.add(s.substring(start,i+1));
                helper(i+1,s,li);
                li.remove(li.size()-1);
            }
        }
    }
    public boolean palindrome(String str,int left,int right)
    {

        while(left<right)
        {
            if(str.charAt(left++)!=str.charAt(right--))
            {
                return false;
            }
        }
        return true;
    }
}