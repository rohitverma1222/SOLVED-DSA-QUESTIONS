class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        
        int pat[]=new int[256];
        int str[]=new int[256];
        
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            pat[ch]++;
        }
        int start=0;
        int start_ind=-1;
        int min=Integer.MAX_VALUE;
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            str[ch]++;
            if(str[ch]<=pat[ch])
                c++;
            
            if(c==t.length())
            {
                while(str[s.charAt(start)]>pat[s.charAt(start)] || pat[s.charAt(start)]==0)
                {
                    if(str[s.charAt(start)]>pat[s.charAt(start)])
                        str[s.charAt(start)]--;
                    
                    start++;
                }
                
                int len=i-start+1;
                if(len<min)
                {
                    min=len;
                    start_ind=start;
                }
                
            }
        }
        
        if(start_ind==-1)
            return "";
        else
            return s.substring(start_ind,start_ind+min);
   }
}