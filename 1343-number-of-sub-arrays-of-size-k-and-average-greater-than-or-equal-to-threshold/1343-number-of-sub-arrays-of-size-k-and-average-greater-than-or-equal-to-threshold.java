class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int i=0;
        for(i=0;i<k;i++)
        {
            sum+=arr[i];
        }
        int j=0;
        int ans=0;
        while(i<arr.length)
        {
            if(sum/k>=threshold)
                ans++;
            sum+=arr[i];
            sum-=arr[j];
            j++;
            i++;
        }
        System.out.println(sum);
        return ans+(sum/k>=threshold?1:0);
    }
}