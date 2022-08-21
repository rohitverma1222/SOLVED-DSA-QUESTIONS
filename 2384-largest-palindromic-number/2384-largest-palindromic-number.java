class Solution {
    public String largestPalindromic(String num) {
        int arr[]=new int[10];
        for(int i=0;i<num.length();i++)
        {
            arr[num.charAt(i)-'0']++;
        }       
        StringBuilder ans=new StringBuilder();
        for(int i=9;i>=0;i--)
        {
            if(ans.length()==0 && i==0)
                continue;
            int mod=arr[i]%2;
            int size=arr[i]/2;
            while(size-->0)
            {
                ans.append(i+"");
            }
            arr[i]=mod;
        }
        
        // ans=new StringBuilder(ans.substring(idx));
        // System.out.println(ans);
        StringBuilder ans2=new StringBuilder(ans);

        int max=-1;
        for(int i=9;i>=0;i--)
        {
            if(arr[i]>0)
            max=Math.max(max,i);
        }
        if(max!=-1)
        {
            ans.append(max);
        }
        return ans+ans2.reverse().toString();
    }
}