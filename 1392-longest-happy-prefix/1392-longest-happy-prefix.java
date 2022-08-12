class Solution {
    public String longestPrefix(String s) {
        int []lps=new int[s.length()];
        int len=0;

        int i=1;
        int max=0;
        while(i<s.length())
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
            max=Math.max(max,lps[i]);
                i++;
            }
            else if(len==0)
            {
                lps[i]=0;
                len=0;
            max=Math.max(max,lps[i]);
                
                i++;
            }
            else{
                len=lps[len-1];
            }
        }
        return s.substring(0,lps[s.length()-1]);
    }
}