// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class pair{
        Node node;
        int v;
        pair(Node node,int v)
        {
            this.node=node;
            this.v=v;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        HashMap<Integer,Integer> hs=new HashMap<>();
        Queue<pair> mq=new LinkedList<>();
        mq.add(new pair(root,0));
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        while(mq.size()>0)
        {
            pair rem=mq.remove();
            
            l=Math.min(l,rem.v);
            r=Math.max(r,rem.v);
            
            // if(hs.containsKey(rem.v)==false)
            // {
            //     hs.put(rem.v,rem.node.data);
            // }
            // else
            // {
            //     hs.put(rem.v,)
            // }
            hs.put(rem.v,rem.node.data);
            if(rem.node.left!=null)
            {
                mq.add(new pair(rem.node.left,rem.v-1));
            }
            
            if(rem.node.right!=null)
            {
                mq.add(new pair(rem.node.right,rem.v+1));
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        for(int i=l;i<=r;i++)
        {
            ar.add(hs.get(i));
        }
        return ar;
    }
}