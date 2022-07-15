class Solution {
    public int nextGreaterElement(int n) {
        char ch[]=(n+"").toCharArray();
        
        int idx=-1;
        for(int i=ch.length-1;i>0;i--)
        {
            int v1=Integer.parseInt(ch[i]+"");
            int v2=Integer.parseInt(ch[i-1]+"");
            if(v1>v2)
            {
                idx=i-1;
                break;
            }
        }
        if(idx==-1)
            return -1;
        int v2=Integer.parseInt(ch[idx]+"");
        for(int i=ch.length-1;i>idx;i--)
        {
            int v1=Integer.parseInt(ch[i]+"");
            if(v1>v2)
            {
                swap(ch,i,idx);
                break;
            }
        }

        int left=idx+1;
        int right=ch.length-1;

        while(left<right)
        {
            swap(ch,left,right);
            left++;
            right--;
        }
        String str=new String(ch);
        long ans=Long.parseLong(str);
        System.out.println(ans);
        if(ans>Integer.MAX_VALUE)
            return -1;
        return (int)ans;
    }
    public void swap(char []arr,int i,int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}