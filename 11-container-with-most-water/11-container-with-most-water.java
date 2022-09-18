class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int r=height.length-1;
        int max=0;
        while(i<r)
        {
            max=Math.max(max,Math.min(height[i],height[r])*(r-i));
            if(height[i]==height[r])
            {
                i++;
                r--;
            }
            else if(height[i]>height[r])
            {
                r--;
            }
            else{
                i++;
            }
        }
        return max;
    }
}