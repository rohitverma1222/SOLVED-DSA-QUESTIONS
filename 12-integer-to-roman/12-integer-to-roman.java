class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> hs=new HashMap<>();
        hs.put(1,"I");
        hs.put(4,"IV");
        
        hs.put(5,"V");
        hs.put(9,"IX");
        
        hs.put(10,"X");
        hs.put(40,"XL");
        
        hs.put(50,"L");
        hs.put(90,"XC");
        
        hs.put(100,"C");
        hs.put(400,"CD");
        
        hs.put(500,"D");
        hs.put(900,"CM");
        
        hs.put(1000,"M");
        
        String ans="";
        int i=1;
        int t=num;
        while(t>0)
        {
            int v=t%10;
            if(hs.containsKey(v*i))
            {
                ans=hs.get(v*i)+ans;
            }
            else 
            {
                if(v<=5)
                {
                    for(int j=0;j<v;j++){
                        ans=hs.get(i)+ans;
                    }
                }
                else if(v>5)
                {
                    for(int j=0;j<v-5;j++)
                    {
                        ans=hs.get(i)+ans;
                    }
                    ans=hs.get(5*i)+ans;
                }
            }
            // System.out.println("work");
            t/=10;
            i*=10;
        }
        return ans;
        
    }
}