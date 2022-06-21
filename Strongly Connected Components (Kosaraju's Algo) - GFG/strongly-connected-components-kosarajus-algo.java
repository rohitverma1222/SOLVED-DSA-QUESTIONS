// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean []visited=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==false)
            {
                dfs(i,adj,visited,st);
            }
        }
        
        // trasnpose
        ArrayList<ArrayList<Integer>> tran=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            tran.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<V;i++)
        {
            for(int v:adj.get(i))
                tran.get(v).add(i);
        }
        int c=0;
        boolean visit[]=new boolean[V];
        while(st.size()!=0)
        {
            int i=st.pop();
            if(visit[i]==false)
                {
                    dfs1(i,tran,visit);
                    c++;
                }
        }
        return c;
    }
    public void dfs1(int src,ArrayList<ArrayList<Integer>> adj,boolean []visited)
    {
        visited[src]=true;
        for(int nbr:adj.get(src))
        {
            if(visited[nbr]==false)
                dfs1(nbr,adj,visited);
        }
    }
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean []visited,Stack<Integer> st)
    {
        visited[src]=true;
        for(int nbr:adj.get(src))
        {
            if(visited[nbr]==false)
                dfs(nbr,adj,visited,st);
        }
        
        st.push(src);
    }
}
