class SnapshotArray {
    HashMap<Integer,Integer> [] map;
    int currsnap;
    public SnapshotArray(int length) {
        map=new HashMap[length];
        for(int i=0;i<length;i++)
        {
            map[i]=new HashMap<>();
        }
        currsnap=0;
    }
    
    public void set(int index, int val) {
        map[index].put(currsnap,val);
    }
    
    public int snap() {
        return currsnap++;
    }
    
    public int get(int index, int snap_id) {
        while(snap_id>=0)
        {
            if(map[index].containsKey(snap_id))
                return map[index].get(snap_id);
            snap_id--;
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */