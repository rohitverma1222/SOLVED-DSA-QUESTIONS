class Solution {
    public void sortColors(int[] arr) {
        int i=0;
    int j=0;
    int k=arr.length-1;
    while(i<=k)
    {
        if(arr[i]==0)
        {
            swap(arr,i,j);
            i++;
            j++;
        }else if(arr[i]==2)
        {
            swap(arr,i,k);
            k--;
        }
        else if(arr[i]==1)
        {
            i++;
        }
    }
    }
    public static void swap(int[] arr, int i, int j) {
    // System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
