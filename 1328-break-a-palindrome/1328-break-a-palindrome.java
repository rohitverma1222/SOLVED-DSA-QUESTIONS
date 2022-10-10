class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)
        {
            return "";
        }
        boolean change=false;
        StringBuilder str=new StringBuilder();
        int mid=0;
        for(char ch:palindrome.toCharArray())
        {
            if(ch!='a' && change==false && mid!=palindrome.length()/2)
            {
                str.append('a');
                change=true;
            }
            else{
                str.append(ch);
            }
            mid++;
        }
        if(change)
            return str.toString();
        else
            return str.deleteCharAt(str.length()-1).append('b').toString();
    }
}