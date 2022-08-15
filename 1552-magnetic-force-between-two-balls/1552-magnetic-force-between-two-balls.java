class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int l=0;
        int h=position[position.length - 1] - position[0];
        int min=0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(pos(position,mid,m))
            {
                min=mid;
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return min;
    }
    public boolean pos(int []position,int gap,int m)
    {
        int last=position[0];

        for(int i=1;i<position.length && m!=1;i++)
        {
            if(position[i]-last>=gap)
            {
                last=position[i];
                m--;
            }
        }
        return m==1;
    }
}