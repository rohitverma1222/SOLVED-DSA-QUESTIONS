class Solution {
    class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src,int nbr,int wt)
        {
            this.src=src;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    class pair implements Comparable<pair>{
        int src;
        String path="";
        int wt;
        pair(int src,int wt,String path)
        {
            this.src=src;
            this.wt=wt;
            this.path=path;
        }
        public int compareTo(pair p)
        {
            
            return this.wt-p.wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int work=0;
        boolean []visit=new boolean[times.length+2];
        ArrayList<Edge> []graph=new ArrayList[times.length+2];
        
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<times.length;i++)
        {
            int src=times[i][0];
            int nbr=times[i][1];
            int wt=times[i][2];
            if(visit[src]==false)
            {
                visit[src]=true;
                work++;
            }
            if(visit[nbr]==false)
            {
                visit[nbr]=true;
                work++;
            }
            graph[src].add(new Edge(src,nbr,wt));
        }
        int ans=0;
        PriorityQueue<pair> pq=new PriorityQueue<>();
        pq.add(new pair(k,0,""));
        boolean visited[]=new boolean[graph.length];
         while(pq.size()!=0)
         {
             pair rem=pq.remove();
             
             
             if(visited[rem.src]==true)
                 continue;
             
             visited[rem.src]=true;
             ans=rem.wt;
             
             for(Edge e:graph[rem.src])
             {
                 if(visited[e.nbr]==false)
                 {
                     pq.add(new pair(e.nbr,e.wt+rem.wt,rem.path+"+"+e.src));
                 }
             }
             
         }
        // System.out.println(work);
        if(work<n)
            return -1;
        for(int i=1;i<visited.length;i++)
        {
            if(visited[i]==false)
            {
                if(graph[i].size()!=0)
                    return -1;
            }
        }
        return ans;
    }
}





