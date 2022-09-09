class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        });

        int max=Integer.MIN_VALUE;
        int p=0;
        for(int i=0;i<properties.length;i++)
        {
            if(properties[i][1]<max)
            {
                p++;
            }
                max=Math.max(max,properties[i][1]);
        }
        return p;
    }
}