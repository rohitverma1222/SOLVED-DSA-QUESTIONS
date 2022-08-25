class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            else
                return b[0]-a[0];
        });
        
        // for(int i[]:properties)
        // {
        //     for(int v:i)
        //         System.out.print(v);
        //     System.out.println();
        // }

        int min=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<properties.length;i++)
        {
            if(properties[i][1]<min)
            {
                res++;
            }
            min=Math.max(min,properties[i][1]);
        }
        return res;
    }
}