class Solution {
    public int maximalRectangle(char[][] matrix) {
        int h[]=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                h[j]=matrix[i][j]=='0'? 0 : h[j]+1;
            }
            max=Math.max(max,largestRect(h));
        }
        return max;
    }
    public int largestRect(int []arr)
    {
        int larr[]=left(arr);
        int rarr[]=right(arr);

        int max=0;
        for(int i=0;i<arr.length;i++)
            max=Math.max(max,(rarr[i]-larr[i]-1)*arr[i]);

        return max;
    }

    public int[] left(int []arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int []ans=new int[n];
        ans[0]=-1;
        st.push(0);
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
                st.pop();

            if(st.size()==0)
                ans[i]=n;
            else
                ans[i]=st.peek();

            st.push(i);
        }
        return ans;
    }
}