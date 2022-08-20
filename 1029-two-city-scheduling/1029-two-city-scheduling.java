class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->{
            return (a[1]-a[0])-(b[1]-b[0]);
        });

        int sum=0;
        for(int i=0;i<costs.length;i++)
        {
            if(i<costs.length/2)
                sum+=costs[i][1];
            else{
                sum+=costs[i][0];
            }
        }
        return sum;
    }
}