class Solution {
    public String shiftingLetters(String ss, int[][] updates) {
        char []ch=ss.toCharArray();
        int []arr=new int[ss.length()];
        for(int i=0;i<updates.length;i++)
        {
            int s=updates[i][0];
            int e=updates[i][1];
            int val=updates[i][2]==0?-1:1;
            arr[s]+=val;
            if(e+1<ss.length())
            {
                arr[e+1]+=-val;
            }
        }
        int sum=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            int NewChar=(((ch[i]-'a')+sum)%26);
            if(NewChar<0)
                NewChar+=26;

            ans.append((char)('a'+NewChar));
        }
        return ans.toString();
    }
}