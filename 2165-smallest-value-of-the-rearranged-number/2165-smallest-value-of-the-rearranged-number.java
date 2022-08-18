class Solution {
    public long smallestNumber(long nums) {
        if(nums<0)
        {
            String n=nums+"";
            n=n.substring(1);
            char []arr=n.toCharArray();
            Arrays.sort(arr);
            String ans="";
            for(char ch:arr)
            {
                ans=ch+""+ans;
            }
            return Long.parseLong("-"+ans);
        }
        else{
            String n=nums+"";
            char []arr=n.toCharArray();
            Arrays.sort(arr);
            if(arr[0]=='0')
            {
                int j=0;
                while(j<arr.length && arr[j]=='0')
                {
                    j++;
                }
                if(j<arr.length)
                    swap(arr,0,j);
            }
            String ans="";
            for(char ch:arr)
            {
                ans+=ch+"";
            }
            return Long.parseLong(ans);
        }
    }
    public void swap(char ch[],int l,int r)
    {
        char c=ch[l];
        ch[l]=ch[r];
        ch[r]=c;
    }
}