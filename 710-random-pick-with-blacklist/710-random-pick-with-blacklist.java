class Solution {
    HashMap<Integer,Integer> hs;
    int lim;
    public Solution(int n, int[] blacklist) {
        hs=new HashMap<>();
        lim=0;
        for(int i:blacklist)
            hs.put(i,-1);
        Arrays.sort(blacklist);
        int j=n-1;
        for(int i=0;i<blacklist.length;i++)
        {
            while(hs.containsKey(j))
                j--;
            hs.put(blacklist[i],j);
            j--;
        }
        lim=n-blacklist.length;
    }
    
    public int pick() {
        int val=(int)(Math.random()*lim);
        if(hs.containsKey(val))
            return hs.get(val);
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */