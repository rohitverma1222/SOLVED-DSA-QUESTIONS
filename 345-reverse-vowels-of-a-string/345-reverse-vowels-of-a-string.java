class Solution {
    public String reverseVowels(String s) {
        StringBuilder str=new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        
        while(i<j)
        {
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            
            if(isVowel(ch1) && isVowel(ch2))
            {
                str.setCharAt(i,ch2);
                str.setCharAt(j,ch1);
                i++;
                j--;
            }
            else if(isVowel(ch1))
                j--;
            else
                i++;
            
        }
        return str.toString();
    }
    public boolean isVowel(char ch)
    {
        if(ch=='a' ||ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' ||ch=='E' || ch=='I' || ch=='O' || ch=='U')
            return true;
        return false;
    }
}