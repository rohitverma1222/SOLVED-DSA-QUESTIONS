class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])
            {
                return a[0]-b[0];
            }
            else{
                return b[1]-a[1];
            }
        });
        for(int i[]:arr)
        {
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
        int tail[]=new int[arr.length];
        tail[0]=arr[0][1];
        int len=1;
        for(int i=1;i<arr.length;i++)
        {
            if(tail[len-1]<arr[i][1])
            {
                len++;
                tail[len-1]=arr[i][1];
            }
            else{
                int idx=Arrays.binarySearch(tail,0,len-1,arr[i][1]);
                
                if(idx<0)
                {
                    idx=-idx;
                    idx-=1;
                }
                tail[idx]=arr[i][1];
            }
        }
        return len;
    }
}