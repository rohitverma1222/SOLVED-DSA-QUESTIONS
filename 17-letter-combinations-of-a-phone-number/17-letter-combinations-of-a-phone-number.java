class Solution {
    String []key={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> li=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return li;
        helper(digits,"");
        return li;
    }
    public void helper(String digits,String asf)
    {
        if(digits.length()==0)
        {
            // System.out.println(asf);
            li.add(asf);
            return;
        }
        
        char ch=digits.charAt(0);
        String rest=digits.substring(1);
        for(int i=0;i<key[ch-'0'].length();i++)
        {
            char chs=key[ch-'0'].charAt(i);
            helper(rest,asf+chs);
        }
    }
}