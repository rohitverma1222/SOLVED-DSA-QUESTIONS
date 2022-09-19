class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2==1)
            return false;
        int bal=0;

        for(int i=0;i<s.length();i++)
        {
            if(locked.charAt(i)=='0' || s.charAt(i)=='(')
                bal++;
            else
                bal--;

            if(bal<0)
                return false;
        }

        bal=0;

        for(int i=s.length()-1;i>=0;i--)
        {
            if(locked.charAt(i)=='0' || s.charAt(i)==')')
                bal++;
            else
                bal--;

            if(bal<0)
                return false;
        }
        return true;
    }
}