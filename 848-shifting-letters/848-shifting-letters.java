class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n=s.length();
        char ch[]=s.toCharArray();
        long []arr=new long[n];
        for(int i=0;i<shifts.length;i++)
        {
            long val=shifts[i];

            arr[0]+=val;
            if(i+1<n)
            {
                arr[i+1]-=val;
            }
        }
        long sum=0;
            StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            long newChar=((ch[i]-'a')+sum)%26;
            if(newChar<0)
            {
                newChar+=26;
            }
            str.append((char)('a'+newChar)+"");
        }
        return str.toString();
    }
}