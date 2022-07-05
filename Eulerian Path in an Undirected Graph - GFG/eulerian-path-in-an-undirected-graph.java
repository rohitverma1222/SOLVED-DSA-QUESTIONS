// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        int e=0;
        int c=0;
        for(int i=0;i<graph.length;i++)
        {
            e=0;
        	for(int j=0;j<graph[0].length;j++)
        	{
        		if(i!=j &&graph[i][j]==1)
        			e++;
        	}
        	if(e%2==1)
        	    c++;
        }
        if(c==0 || c==2)
            return 1;
            return 0;

    }
}