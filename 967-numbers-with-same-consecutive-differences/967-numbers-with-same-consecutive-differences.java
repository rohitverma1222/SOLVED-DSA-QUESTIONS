class Solution {
    List<Integer> li;
    public int[] numsSameConsecDiff(int n, int k) {
        li=new ArrayList<>();
        for(int i=1;i<=9;i++)
        {
            helper(i,n,k,i);
        }
        int []arr=new int[li.size()];
        int i=0;
        for(int str:li)
        {
            arr[i++]=str;
        }
        return arr;
    }
    public void helper(int psf,int n,int k,int prev)
    {
        if(n==1)
        {
            li.add(psf);
            return;
        }

        if(prev+k<10)
        {
            helper(psf*10+(prev+k),n-1,k,prev+k);
        }
        if(k !=0 && prev-k>-1)
        {
            helper(psf*10+(prev-k),n-1,k,prev-k);
        }

    }
}