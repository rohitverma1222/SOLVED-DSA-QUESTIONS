// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




    //Function to find the minimum number of swaps required to sort the array.
   class Solution
{
    public int minSwaps(int nums[])
    {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int i=0;
        for(int n:nums)
        {
            hs.put(n,i++);
        }
        int ans=0;
        Arrays.sort(nums);
        boolean visited[]=new boolean[nums.length];
        for(i=0;i<nums.length;i++)
        {
            if(visited[i]==true || hs.get(nums[i])==i)
                continue;

            visited[i]=true;
            int j=i;
            int c=0;
            do{
                j=hs.get(nums[j]);
                c++;
                visited[j]=true;
                // j=val;

            }while(j!=i);
            ans+=(c-1);
        }
        return ans;
    }
}


