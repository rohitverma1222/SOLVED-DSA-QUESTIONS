class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            if(st.size()==0 || st.peek()<0 || asteroids[i]>0)
            {
                st.push(asteroids[i]);
            }
            else{
                while (st.size()>0 && st.peek()>0 && Math.abs(asteroids[i])>st.peek()) {
                    st.pop();
                }

                if(st.size()==0 || st.peek()<0)
                {
                    st.push(asteroids[i]);
                }
                else if(Math.abs(asteroids[i])==st.peek())
                {
                    st.pop();
                }
            }
        }
        int ans[]=new int[st.size()];
        int i=st.size()-1;
        while(st.size()!=0)
        {
            ans[i--]=st.pop();
        }
        return ans;
    }
}