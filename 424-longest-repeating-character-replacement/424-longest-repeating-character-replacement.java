class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,n=s.length(),arr[]=new int[26];
        int max=0;
        for(int j=0;j<s.length();j++)
        {
            char ch=s.charAt(j);
            max=Math.max(max,++arr[ch-'A']);
            if(j-i+1>max+k)
                --arr[s.charAt(i++)-'A'];
        }
        return n-i;
    }
}