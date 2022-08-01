class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            while(st.size()>0 && nums[i]>=nums[st.peek()])
            {
                st.pop();
            }
            
            if(st.size()==0)
                res[i]=nums.length;
            else
                res[i]=st.peek();
            
            st.push(i);
        }
        
        int j=0;
        int ans[]=new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
            if(i>j)
                j=i;
            
            while(res[j]<i+k)
                j=res[j];
            
            ans[i]=nums[j];
            // System.out.println(nums[j]);
        }
        return ans;
    }
}