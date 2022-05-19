// { Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public void leftview(Node node,List<Integer> li)
    {
        if(node==null)
        return ;
        if(!isLeaf(node))
            li.add(node.data);
        if(node.left!=null)
            leftview(node.left,li);
        else if(node.right!=null)
            leftview(node.right,li);
    }
    public void rightview(Node node,List<Integer> li)
    {
        if(node==null)
            return ;
        
        if(node.right!=null)
            rightview(node.right,li);
        else if(node.left!=null)
            rightview(node.left,li);
          if(!isLeaf(node))   
            li.add(node.data);
    }
    public boolean isLeaf(Node node)
    {
        if(node.left==null && node.right==null)
            return true;
        else
            return false;
    }
    public void leaves(Node node,List<Integer> li)
    {
        if(node==null)
        return;
        
        leaves(node.left,li);
        if(isLeaf(node))
            li.add(node.data);
        leaves(node.right,li);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> li=new ArrayList<>();
	    if(node==null)
	        return li;
	    li.add(node.data);
	    if(node.left==null && node.right==null)
	        return li;
	    leftview(node.left,li);
	    
	    leaves(node,li);
	    
	    rightview(node.right,li);
	    return li;
	}
}
