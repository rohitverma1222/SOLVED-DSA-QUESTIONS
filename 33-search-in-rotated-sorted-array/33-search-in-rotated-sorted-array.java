class Solution {
    public int search(int[] arr, int target) {
        int l=0;
        int h=arr.length-1;

        while(l<=h)
        {
            int mid=(l+h)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<arr[h])
            {
                if(arr[h]>=target && arr[mid]<=target)
                {
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            else if(arr[mid]>arr[h])
            {
                if(arr[l]<=target && arr[mid]>=target)
                {
                    h=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                h--;
            }
        }
        return -1;
    }
}