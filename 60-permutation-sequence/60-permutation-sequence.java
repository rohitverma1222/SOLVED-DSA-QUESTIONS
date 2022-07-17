class Solution {
    public String getPermutation(int n, int k) {
        String str="";
        for(int i=1;i<=n;i++)
        {
            str+=i;
        }
        int times=fact(n);
        // k=k%times;
        char ch[]=str.toCharArray();
        for(int j=0;j<k-1;j++)
        {
            int idx=0;
            for(int i=ch.length-1;i>0;i--)
            {
                int v1=Integer.parseInt(ch[i-1]+"");
                int v2=Integer.parseInt(ch[i]+"");

                if(v1<v2)
                {
                    idx=i-1;
                    break;
                }
            }
                int v2=Integer.parseInt(ch[idx]+"");

            for(int i=ch.length-1;i>0;i--)
            {
                int v1=Integer.parseInt(ch[i]+"");

                if(v1>v2)
                {
                    swap(ch,idx,i);
                    break;
                }
            }    
            reverse(ch,idx+1,ch.length-1);
            // System.out.println(new String(ch));
        }
        return new String(ch);
    }
    void swap(char []arr,int i,int j)
    {
        char ch=arr[i];
        arr[i]=arr[j];
        arr[j]=ch;
    }

    void reverse(char []arr,int i,int j)
    {
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public int fact(int n)
    {
        if(n==0 || n==1)
            return 1;

        int []dp=new int[n+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=i*dp[i-1];
        }

        return dp[n];
    }
}