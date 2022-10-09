class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i:arr)
        {
            if(i!=0)
                hs.put(i,hs.getOrDefault(i,0)+1);
        }
        Arrays.sort(arr);
        
        for(int i:arr)
        {
            if(hs.containsKey(i) &&hs.containsKey(i*2))
            {
                hs.put(i,hs.get(i)-1);
                hs.put(i*2,hs.get(i*2)-1);
                if(hs.get(i)==0)
                    hs.remove(i);
                
                if(hs.get(i*2)==0)
                    hs.remove(i*2);
            }
        }
        return hs.size()==0;
    }
}