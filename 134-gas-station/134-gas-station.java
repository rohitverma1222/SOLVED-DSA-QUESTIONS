class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int val=0;
        int p=0;
        for(int i=0;i<gas.length;i++)
        {
            sum+=(gas[i]-cost[i]);
            val+=(gas[i]-cost[i]);
            
            if(val<0)
            {
                val=0;
                p=i+1;
            }
        }
        if(sum>=0)
            return p;
        return -1;
    }
}