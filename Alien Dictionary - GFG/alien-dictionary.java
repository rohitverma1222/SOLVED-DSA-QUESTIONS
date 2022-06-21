// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int k)
    {
        // Write your code here
        ArrayList<Integer> []graph=(ArrayList<Integer>[])new ArrayList[k];
        for(int i=0;i<k;i++)
        {
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<dict.length-1;i++)
        {
            String f=dict[i];
            String s=dict[i+1];
            
            for(int j=0;j<f.length() && j<s.length();j++)
            {
                char ch1=f.charAt(j);
                char ch2=s.charAt(j);
                if(ch1!=ch2)
                {
                    graph[ch1-'a'].add(ch2-'a');
                    break;
                }
            }
        }
        boolean []visited=new boolean[k];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++)
        {
            if(visited[i]==false)
                dfs(i,graph,visited,st);
        }
        String ans="";
        while(st.size()>0)
        {
            char ch=(char)(st.pop()+'a');
            // System.out.println(ch);
            ans+=ch;
        }
        
        return ans;
    }
    public void dfs(int src,ArrayList<Integer>[] adj,boolean []visited,Stack<Integer> st)
    {
        visited[src]=true;
        for(int nbr:adj[src])
        {
            if(visited[nbr]==false)
                dfs(nbr,adj,visited,st);
        }
        
        st.push(src);
    }
}