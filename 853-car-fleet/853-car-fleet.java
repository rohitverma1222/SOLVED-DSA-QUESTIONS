class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());   

        for(int i=0;i<position.length;i++)
        {
            map.put(position[i],speed[i]);
        }
        double time=0;
        int c=0;
        for(int pos:map.keySet())
        {
            int sp=map.get(pos);

            double ctime=(target-pos)*1.0/sp;

            if(ctime>time)
            {
                time=ctime;
                c++;
            }
        }
        return c;
    }
}