class Solution {
    public int maxChunksToSorted(int[] arr) {
        int min[]=new int[arr.length];
        min[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            min[i]=Math.min(min[i+1],arr[i]);
        }
        
        int max=arr[0];
        int c=1;
        for(int i=0;i<arr.length-1;i++)
        {
            max=Math.max(max,arr[i]);
            if(max<=min[i+1])
                c++;
        }
        return c;
    }
}