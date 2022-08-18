class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String []arr=new String[n];
        int idx=0;
        for(int i:nums)
        {
            arr[idx++]=i+"";
        }

        Arrays.sort(arr,(a,b)->{
            String case1=a+b;
            String case2=b+a;
            return case2.compareTo(case1);
        });


        String ans="";
        if(arr[0].equals("0"))
            return "0";
        for(String str:arr)
        {
            ans+=str;
        }
        return ans;
    }
}