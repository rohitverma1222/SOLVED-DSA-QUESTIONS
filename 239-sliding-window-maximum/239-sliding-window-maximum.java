class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        st.push(nums.length-1);
        int res[]=new int[n];
        res[n-1]=nums.length;

        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && nums[i]>=nums[st.peek()])
                st.pop();

            if(st.size()==0)
                res[i]=n;
            else
                res[i]=st.peek();;

            st.push(i);
        }


        int j=0;
        int ans[]=new int[n-k+1];
        for(int i=0;i<ans.length;i++)
        {
            if(i>j)
                j=i;

            while(res[j]<i+k)
                j=res[j];

            ans[i]=nums[j];
        }

        return ans;
        
    }
}