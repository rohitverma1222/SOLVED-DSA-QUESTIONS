class Solution {
    public boolean queryString(String s, int n) {
        // if()
        // Set<Integer> hs=new HashSet<>();
        for(int i=n;i>n/2;i--)
        {
            String find=Integer.toBinaryString(i);
            System.out.println(find);
            if(s.indexOf(find)==-1)
                return false;
        }
        return true;
    }
}