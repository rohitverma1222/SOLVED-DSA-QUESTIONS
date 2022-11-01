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
            hss.add(ar.size());
            hs.put(val,hss);
            ar.add(val);
            return true;
        }
        else{
            hs.get(val).add(ar.size());
            ar.add(val);
            return false;
        }
    }
    
    public boolean remove(int val) {
        if(hs.containsKey(val)==false)
            return false;
        int remIdx=hs.get(val).stream().findFirst().get();
        if(remIdx==ar.size()-1)
        {
            hs.get(val).remove(remIdx);
            ar.remove(ar.size()-1);
        }
        else{
            int lastvalue=ar.get(ar.size()-1);
            if(lastvalue==val)
            {
                hs.get(lastvalue).remove(ar.size()-1);
                ar.remove(ar.size()-1);
            }
            else{
                ar.set(remIdx,lastvalue);
                
                hs.get(lastvalue).remove(ar.size()-1);
                hs.get(lastvalue).add(remIdx);

                ar.remove(ar.size()-1);
                hs.get(val).remove(remIdx);
            }
            
            if(hs.get(lastvalue).size()==0)
                    hs.remove(lastvalue);
        }
        
        if(hs.get(val).size()==0)
                hs.remove(val);
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