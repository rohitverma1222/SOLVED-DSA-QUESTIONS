class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new peopleComparator());
        
        List<int[]> li=new ArrayList<int[]>();
        
        for(int []p:people)
        {
            li.add(p[1],p);
        }
        
        return li.toArray(new int[people.length][2]);
    }
    public class peopleComparator implements Comparator<int[]>
    {
        public int compare(int []a,int []b)
        {
            if(a[0]==b[0])
                return a[1]-b[1];
            return b[0]-a[0];
        }
    }
}