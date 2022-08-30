class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        PriorityQueue<int[]> used=new PriorityQueue<>((a,b)->{
            if(a[2]!=b[2])
                return a[2]-b[2];
            else if(a[0]!=b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });


        for(int i=0;i<servers.length;i++)
        {
            free.add(new int[]{ servers[i],i,0});
        }
        int res[]=new int[tasks.length];
        for(int i=0;i<tasks.length;i++)
        {
            int t=tasks[i];

            while(used.size()!=0 && used.peek()[2]<=i)
                free.add(used.remove());


            if(free.size()==0)
            {
                int []curr=used.remove();
                res[i]=curr[1];
                curr[2]+=t;
                used.add(curr);
            }
            else{
                int []curr=free.remove();
                res[i]=curr[1];
                curr[2]=i+t;
                used.add(curr);
            }
        }
        return res;
    }
}