class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder str=new StringBuilder();

        for (int i=0;i<n ;i++ ) {
            str.append("0");
        }
    HashSet<String> hs=new HashSet<>();
        hs.add(str.toString());
        gen(str,k,n,hs);
        return str.toString();
    }
    public boolean gen(StringBuilder str,int k,int n,HashSet<String> hs) 
    {
        if(hs.size()==(int)Math.pow(k,n))
        {
            return true;
        }
        System.out.println(str);
        String ss=str.substring(str.length()-(n-1));
       for(int i=0;i<k;i++)
       {
           String nn=ss+i;
           if(hs.contains(nn)==false)
           {
               hs.add(nn);
               str.append(i);
               if(gen(str,k,n,hs))
                   return true;
               
               hs.remove(nn);
               str.deleteCharAt(str.length()-1);
           }
       }
        return false;
    }
}