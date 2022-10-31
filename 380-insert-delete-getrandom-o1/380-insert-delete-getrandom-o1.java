class RandomizedSet {
    HashMap<Integer,Integer> hs=new HashMap<>();
    List<Integer> arr=new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {
        hs=new HashMap<>();
        arr=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hs.containsKey(val))
            return false;
        hs.put(val,arr.size());
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(hs.containsKey(val))
        {
            if(hs.get(val)<arr.size()-1)
            {
                int idx=hs.get(val);
                arr.set(idx,arr.get(arr.size()-1));
                hs.put(arr.get(arr.size()-1),idx);
            }
            arr.remove(arr.size()-1);
            hs.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */