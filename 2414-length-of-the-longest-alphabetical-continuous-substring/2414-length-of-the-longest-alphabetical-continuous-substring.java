class Solution {
    public int longestContinuousSubstring(String s) {
        int prev=s.charAt(0)-'a';
        int diff=1;
        int len=1;
        int max=0;
        for(int i=1;i<s.length();i++){
            int ch=s.charAt(i)-'a';
            if(prev<ch && ch-prev==diff)
            {
                len+=1;
                prev=ch;
            }
            else
            {
                len=1;
                prev=ch;
            }
                max=Math.max(len,max);
        }
        return Math.max(len,max);
    }
}