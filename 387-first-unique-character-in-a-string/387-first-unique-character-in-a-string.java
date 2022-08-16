class Solution {
    public int firstUniqChar(String s) {
        int []arr=new int[26];

        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }

        int idx=0;
        for(char ch:s.toCharArray())
        {
            if(arr[ch-'a']==1)
                return idx;
            idx++;
        }
        return -1;
    }
}