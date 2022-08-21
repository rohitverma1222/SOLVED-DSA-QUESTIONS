class Solution {
    public String largestPalindromic(String num) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<num.length();i++)
        {
            int ch=Integer.parseInt(num.charAt(i)+"");
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        String str="";
        for(int i=9;i>=0;i--)
        {
            if(hs.containsKey(i) && (hs.get(i)/2)>0)
            {
                int mod=hs.get(i)%2;
                int size=hs.get(i)/2;
                while(size-->0)
                {
                    str+=i;
                }
                hs.put(i,mod);
                if(mod==0)
                hs.remove(i);
            }
        }
        // System.out.println(str);
        int idx=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!='0')
            {
                idx=i;
                break;
            }
        }
        str=str.substring(idx);
        StringBuilder right=new StringBuilder(str);
        int max=-1;
        for(int i:hs.keySet())
        {
            max=Math.max(i,max);
        }
        if(max!=-1)
        str+=max;
        if(str.charAt(0)!='0')
        return str+right.reverse().toString();
        else
            return max==-1?0+"":max+"";
    }
}