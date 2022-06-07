class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ans[]=new int[m+n];
        int i=0;
        int j=0;
        int idx=0;
        while(i<m && j<n)
        {
            if(nums1[i]<nums2[j])
            {
                ans[idx]=nums1[i];
                i++;
                idx++;
            }
            else
            {
                ans[idx]=nums2[j];
                j++;
                idx++;
            }
        }
        
        while(i<m)
        {
            ans[idx]=nums1[i];
            i++;
            idx++;
        }
        while(j<n)
        {
            ans[idx]=nums2[j];
            j++;
            idx++;
        }
        for(i=0;i<ans.length;i++)
        {
            nums1[i]=ans[i];
        }
    }
}