class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int j=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            while(hs.contains(ch))
            {
                char chj=s.charAt(j++);
                hs.remove(chj);
            }
            hs.add(ch);
            max=Math.max(max,i-j+1);
        }
        return max;
    }
}