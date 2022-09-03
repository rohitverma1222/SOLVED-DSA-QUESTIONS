class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1)
            return heights[0];
        int larr[]=left(heights);
        int rarr[]=right(heights);

        int max=0;
        for(int i=0;i<heights.length;i++)
        {
            max=Math.max(max,(rarr[i]-larr[i]-1)*heights[i]);
        }

        return max;
    }
    public int[] right(int []arr)
    {
        int n=arr.length;
        int []ans=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        ans[n-1]=n;
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()>0 && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }

            if(st.size()==0)
            {
                ans[i]=n;
            }
            else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] left(int []arr)
    {
        int n=arr.length;
        int []ans=new int[n];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        ans[0]=-1;
        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && arr[i]<=arr[st.peek()])
                st.pop();

            if(st.size()==0)
                ans[i]=-1;
            else
                ans[i]=st.peek();

            st.push(i);
        }
        return ans;
    }

}