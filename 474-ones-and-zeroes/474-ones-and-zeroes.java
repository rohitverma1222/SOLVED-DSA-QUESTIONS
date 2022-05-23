class Solution {
    int ma=0;
    public int findMaxForm(String[] strs, int m, int n) {
        
         return helper(strs,0,m,n,new int[m+1][n+1][strs.length+1]);
    }
    public int helper(String []strs,int i,int m,int n,int dp[][][])
    {
        if(dp[m][n][i]>0)
            return dp[m][n][i];
        if(i==strs.length || m+n==0)
            return 0;
        
        int []cc=count(strs[i]);
        int l=0;
        if(m>=cc[1] && n>=cc[0])
            l=helper(strs,i+1,m-cc[1],n-cc[0],dp)+1;

        int r=helper(strs,i+1,m,n,dp);
        dp[m][n][i]=Math.max(l,r);
        return Math.max(l,r);
    }
    public int[] count(String s)
    {
        int o=0;
        int z=0;
        int []arr=new int[2];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
                z++;
            else
                o++;
        } 
        arr[0]=o;
        arr[1]=z;
        return arr;
    }
}