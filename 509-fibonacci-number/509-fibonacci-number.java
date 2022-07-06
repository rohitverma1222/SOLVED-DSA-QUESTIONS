class Solution {
    public int fib(int n) {
        if(n==0)
            return 0;
        int arr[]=new int[n+1];
        arr[0]=1;
        int sum=0;
        for(int i=1;i<arr.length;i++)
        {
            arr[i]+=arr[i-1];
            if(i-2>=0)
            {
                arr[i]+=arr[i-2];
            }
        }
        return arr[n-1];
    }
}