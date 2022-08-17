class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int []ans=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m)
        {
            if(nums1[i]<nums2[j])
            {
                ans[k++]=nums1[i++];
            }
            else{
                ans[k++]=nums2[j++];
            }
        }

        while(i<n)
        {
            ans[k++]=nums1[i++];
        }
        while (j<m) {
            ans[k++]=nums2[j++];
        }
        
                    // System.out.println(ans[n/2]);
        n=ans.length;
        if(ans.length%2==0)
        {
            return (ans[n/2-1]+ans[n/2])/2.0;
        }
        return ans[n/2];
    }
}