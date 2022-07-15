class Solution {
    public int maxArea(int[] h) {
        int l=0;
        int r=h.length-1;
        int sum=0;
        while(l<r)
        {
            int val=Math.min(h[l],h[r]);
            sum=Math.max(val*(r-l),sum);
            if(h[l]==h[r])
            {
                l++;
                r--;
            }
            else if(h[l]<h[r])
            {
                l++;
            }else
                r--;
        }
        return sum;
    }
}