class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int boxes=0;
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        for(int []b:boxTypes)
        {
            if(truckSize>=b[0])
            {
                boxes+=b[0]*b[1];
                truckSize-=b[0];
            }
            else
            {
                boxes+=truckSize*b[1];
                return boxes;
            }
        }
        return boxes;
    }
}