class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        int []str=new int[256];
        int pat[]=new int[256];
        
        for(char ch:t.toCharArray())
            pat[ch]++;
        
        int i=0;
        int j=0;
        int len=s.length()+1;
        String ans="";
        int found=0;
        while(i<s.length())
        {
            char ch=s.charAt(i++);
            if(found<t.length())
            {
                str[ch]++;
                if(str[ch]<=pat[ch])
                    found++;
            }
            while(found==t.length())
            {
                if(len>(i-j))
                {
                    len=i-j;
                    ans=s.substring(j,i);
                }
                char chj=s.charAt(j++);
                str[chj]--;
                if(str[chj]<pat[chj])
                    found--;
            }
        }
        return ans;
    }
}