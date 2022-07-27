class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int []f=new int[60];
        int c=0;
        for(int i=0;i<time.length;i++)
        {
            int val=time[i]%60;
            
            if(val==0)
                c+=f[0];
            else
                c+=f[60-val];
            
            f[val]++;
        }
        return c;
    }
}