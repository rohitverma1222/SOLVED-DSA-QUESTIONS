class Solution {
    HashSet<String> li;
    public int[] numsSameConsecDiff(int n, int k) {
        li=new HashSet<>();
        for(int i=1;i<=9;i++)
        {
            helper(i+"",n,k,i);
        }
        // System.out.println(li);
        int []arr=new int[li.size()];
        int i=0;
        for(String str:li)
        {
            arr[i++]=Integer.parseInt(str);
        }
        return arr;
    }
    public void helper(String psf,int n,int k,int prev)
    {
        if(psf.length()==n)
        {
            // System.out.println(psf);
            if(psf.charAt(0)!='0')
            {
                li.add(psf);
            }
            return;
        }

        if(prev+k<10)
        {
            prev+=k;
            psf+=prev;
            helper(psf,n,k,prev);
            psf=psf.substring(0,psf.length()-1);
            prev-=k;
        }
        if(prev-k>-1)
        {
            prev-=k;
            psf+=prev;
            helper(psf,n,k,prev);
            psf=psf.substring(0,psf.length()-1);
            prev+=k;
        }

    }
}