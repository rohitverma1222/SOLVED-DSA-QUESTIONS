class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> li=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            li.add(new ArrayList<>());
        }

        for(int []c:connections)
        {
            li.get(c[0]).add(c[1]);
            li.get(c[1]).add(-c[0]);
        }
        
        return dfs(li,0,-1);
    }
    public int dfs(List<List<Integer>> li,int src,int dest)
    {
        int c=0;
        for(int val:li.get(src))
        {
           if(Math.abs(val)==dest)
            continue;

            if(val>0)
                c++;
            c+=dfs(li,Math.abs(val),src); 
        }
        return c;
    }
}