class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int []f=new int[26];
        for(int i=0;i<words2.length;i++)
        {
            int temp[]=new int[26];
            for(char ch:words2[i].toCharArray())
            {
                // if(f[ch-'a']==0)
                temp[ch-'a']++;
                f[ch-'a']=Math.max(f[ch-'a'],temp[ch-'a']);
            }
        }
        List<String> li=new LinkedList<>();
        
        for(int i=0;i<words1.length;i++)
        {
            int a[]=new int[26];
            for(char ch:words1[i].toCharArray())
            {
                a[ch-'a']++;
            }
            boolean flag=false;
            for(int j=0;j<26;j++)
            {
                if(a[j]<f[j])
                    flag=true;
            }
            
            if(flag==false)
            {
                    li.add(words1[i]);
            }
        }
        return li;
    }
}