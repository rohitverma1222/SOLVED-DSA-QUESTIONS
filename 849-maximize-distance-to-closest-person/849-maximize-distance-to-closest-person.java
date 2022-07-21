class Solution {
    public int maxDistToClosest(int[] s) {
        int j=-1;
        int res=0;
        for(int i=0;i<s.length;i++)
        {
            if(s[i]==1)
            {
                int ans=0;
                
                if(j<0)
                    ans=i;
                else
                    ans=(i-j)/2;
                res=Math.max(res,ans);
                j=i;
            }
        }
        
        int ans=s.length-j-1;
        res=Math.max(ans,res);
        return res;
    }
}