class Solution {
    public int findMin(int[] arr) {
        int l=0;
        int h=arr.length-1;
        
        while(l<h)
        {
            int mid=(l+h)/2;
            
            if(arr[mid]<arr[h])
                h=mid;
            else
                l=mid+1;
        }
        return arr[l];
    }
}