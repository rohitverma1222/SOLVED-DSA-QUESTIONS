class Solution {
    public String minWindow(String s, String t) {
       if(s.length()<t.length())
        return "";

        int str[]=new int[256];
        int pat[]=new int[256];

        for(char ch:t.toCharArray())
        {
            pat[ch]++;
        }

        String res="";
        int i=0;
        int j=0;
        int len=s.length()+1;
        int found=0;
        while(i<s.length())
        {
            if(found<t.length())
            {
                char ch=s.charAt(i);
                if(pat[ch]>0)
                {
                    str[ch]++;
                    if(str[ch]<=pat[ch])
                        found++;
                }
                i++;
            }
            while(found==t.length())
            {
                if(len>(i-j))
                {
                    len=i-j;
                    res=s.substring(j,i);
                }
                char chj=s.charAt(j);
                if(pat[chj]>0)
                {
                    str[chj]--;
                    if(str[chj]<pat[chj])
                        found--;
                }
                j++;
            }
        }
        return res;
   }
}