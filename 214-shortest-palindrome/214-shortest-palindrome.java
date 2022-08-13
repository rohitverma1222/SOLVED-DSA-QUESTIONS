class Solution {
    public String shortestPalindrome(String s) {
        String str=s+"#"+new StringBuilder(s).reverse().toString();

        int []lps=getLps(str);
        int k=0;
        for(int i=lps.length-1;i>=0;i--)
        {
            if(lps[i]==0)
            {
                k=i;
                break;
            }
        }
        
        return new StringBuilder(s.substring(lps[lps.length-1])).reverse().toString()+s ;
    }
    public int[] getLps(String s)
    {
        int i=1;
        int len=0;
        int []lps=new int[s.length()];

        while(i<s.length())
        {
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else if(len==0)
            {
                lps[i]=len;
                i++;
            }
            else{
                len=lps[len-1];
            }
        }
        return lps;
    }
}