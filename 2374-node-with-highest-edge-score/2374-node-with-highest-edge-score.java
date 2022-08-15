class Solution {
    public int edgeScore(int[] edges) {
        long ans[]=new long[edges.length+1];
        for(int i=0;i<edges.length;i++)
        {
            ans[edges[i]]+=i;
        }
        
        int max=0;
        
        for(int i=0;i<ans.length;i++)
        {
            if(ans[max]<ans[i])
            {
                max=i;
            }
        }
            return max;
    }
}