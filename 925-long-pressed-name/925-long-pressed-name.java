class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int j=0;
        for(int i=0;i<typed.length();i++)
        {
            char n='0';
            if(name.length()>j)
                n=name.charAt(j);
            char t=typed.charAt(i);
            if(n==t)
            {
                j++;
            }
            else if(i-1<0 ||n!=t && typed.charAt(i-1)!=t)
            {
                return false;
            }
        }
        if(j>=name.length())
            return true;
        else 
            return false;
    }
}