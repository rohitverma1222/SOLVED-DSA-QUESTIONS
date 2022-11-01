class RandomizedCollection {
    Random r=new Random();
    HashMap<Integer,HashSet<Integer>> hs;
    ArrayList<Integer> ar;
    public RandomizedCollection() {
        r=new Random();
        hs=new HashMap<>();
        ar=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hs.containsKey(val)==false)
        {
            HashSet<Integer> hss=new HashSet<>();
            hs.put(val,hss);
        }
        hs.get(val).add(ar.size());
        ar.add(val);
        return hs.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        if(hs.containsKey(val)==false || hs.get(val).size()==0)
            return false;
        int remIdx=hs.get(val).iterator().next();
        
        hs.get(val).remove(remIdx);
        int last=ar.get(ar.size()-1);
        ar.set(remIdx,last);
        hs.get(last).add(remIdx);
        hs.get(last).remove(ar.size()-1);
        
        ar.remove(ar.size()-1);
        return true;
    }
    
    public int getRandom() {
        return ar.get(r.nextInt(ar.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */