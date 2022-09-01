class Solution {
    public int findLongestChain(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            return a[1]-b[1];
        });

        int len=1;
        int prev=Integer.MIN_VALUE;
        for(int i[]:arr)
        {
            if(prev<i[0])
            {
                len++;
                prev=i[1];
            }
        }
        return len-1;
    }
}