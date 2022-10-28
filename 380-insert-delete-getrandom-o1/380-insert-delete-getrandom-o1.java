class RandomizedSet {
    ArrayList<Integer> ar;
    HashMap<Integer,Integer> hs;
    Random rand = new Random();
    public RandomizedSet() {
        ar=new ArrayList<>();
        hs=new HashMap<>();        
    }
    
    public boolean insert(int val) {
        if(hs.containsKey(val))
            return false;
        ar.add(val);
        hs.put(val,ar.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(hs.containsKey(val))
        {
            if(hs.get(val)<ar.size()-1)
            {
                int idx=hs.get(val);
                ar.set(idx,ar.get(ar.size()-1));
                hs.put(ar.get(ar.size()-1),idx);
            }
            ar.remove(ar.size()-1);
            hs.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return ar.get(rand.nextInt(ar.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */