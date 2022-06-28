class Solution {
    int []parent;
    int rank[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];

        for(int i=0;i<26;i++)
        {
            parent[i]=i;
            rank[i]=0;
        }

        for(int i=0;i<equations.length;i++)
        {
            String f=equations[i];
            char op=f.charAt(1);
            if(op=='=')
            {
                int first=find(f.charAt(0)-'a');
                int last=find(f.charAt(f.length()-1)-'a');
                if(first!=last)
                    union(first,last);
            }
           
        }
        for(int i=0;i<equations.length;i++)
        {
            String f=equations[i];
            char op=f.charAt(1);
            if(op=='!')
            {
                int first=find(f.charAt(0)-'a');
                int last=find(f.charAt(f.length()-1)-'a');
                if(first==last)
                    return false;
            }
            
        }
        return true;
    }   
    public int find(int x)
    {
        if(parent[x]==x)
            return x;
        int st=find(parent[x]);
        parent[x]=st;
        return st;
    } 

    public void union(int slu,int slv)
    {
            int rankU=rank[slu];
            int rankV=rank[slv];

            if(rankU<rankV)
            {
                parent[slu]=slv;
            }
            else if(rankV<rankU)
            {
                parent[slv]=slu;
            }
            else{
                parent[slu]=slv;
                rank[slv]++;
            }
        }

    
}