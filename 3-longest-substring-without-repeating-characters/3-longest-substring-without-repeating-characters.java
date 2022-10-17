class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int i=0;
        int j=0;
        int len=0;
        while(i<s.length())
        {
            char ch=s.charAt(i);
            
            while(hs.contains(ch))
            {
                char chj=s.charAt(j);
                hs.remove(chj);
                j++;
            }
            len=Math.max(len,i-j+1);
            hs.add(ch);
            i++;
        }
        return len;
    }
}