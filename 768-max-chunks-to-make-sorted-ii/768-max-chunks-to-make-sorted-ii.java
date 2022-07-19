class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            if(st.peek()>arr[i])
            {
                int max=Integer.MIN_VALUE;
                while(st.size()>0 && st.peek()>arr[i])
                {
                    max=Math.max(st.pop(),max);
                }
                st.push(max);
            }
            else{
                st.push(arr[i]);
            }
        }
        return st.size();
    }
}