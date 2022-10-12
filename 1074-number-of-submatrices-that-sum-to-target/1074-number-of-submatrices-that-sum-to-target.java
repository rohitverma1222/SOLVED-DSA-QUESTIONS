class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
            for(int j=1;j<m;j++)
                matrix[i][j]+=matrix[i][j-1];

        int c=0;
        for(int i=0;i<m;i++)
        {
            for(int j=i;j<m;j++)
            {
                HashMap<Integer,Integer> hs=new HashMap<>();
                hs.put(0,1);
                int sum=0;
                for(int k=0;k<n;k++)
                {
                    sum+=matrix[k][j]-(i>0?matrix[k][i-1]:0);
                    if(hs.containsKey(sum-target))
                        c+=hs.get(sum-target);
                    hs.put(sum,hs.getOrDefault(sum,0)+1);
                }
            }
        }
        return c;
    }
}