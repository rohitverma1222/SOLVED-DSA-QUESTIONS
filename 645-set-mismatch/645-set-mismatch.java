class Solution {
    public int[] findErrorNums(int[] nums) {
        int []arr=new int[nums.length+1];
        for(int i:nums)
            arr[i]++;
        int first=0;
        int sec=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>1)
                first=i;
            if(arr[i]==0)
                sec=i;
        }
        return new int[]{first,sec};
    }
}