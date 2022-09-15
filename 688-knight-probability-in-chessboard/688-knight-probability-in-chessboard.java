class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        double [][]curr=new double[n][n];
        double [][]next=new double[n][n];

        curr[r][c]=1;
        int [][]dir=new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
        for(int m=0;m<k;m++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int []d:dir)
                    {
                        int ni=i+d[0];
                        int nj=j+d[1];

                        if(ni>=0 && nj>=0 && ni<n && nj<n && curr[i][j]!=0)
                        {
                            next[ni][nj]+=curr[i][j]/8.0;
                        }
                    }
                }
            }
            curr=next;
            next=new double[n][n];
        }

        double res=0;
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    res+=curr[i][j];
                }
            }
        return res;

    }
}