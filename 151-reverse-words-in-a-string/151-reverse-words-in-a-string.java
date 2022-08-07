class Solution {
    public String reverseWords(String s) {
        String []arr=s.split(" ");
        
        int i=0;
        int j=arr.length-1;
        
        while(i<j)
        {
            if(arr[i].length()==0 && arr[j].length()==0)
            {
                i++;
                j--;
            }
            else if(arr[i].length()==0)
            {
                i++;
            }
            else if(arr[j].length()==0)
            {
                j--;
            }
            else{
                
                String str=arr[i];
                arr[i]=arr[j];
                arr[j]=str;
                i++;
                j--;
            }
        }
        String ans="";
        for(String str:arr)
        {
            if(str.length()!=0)
            ans=ans+str+" ";
        }
        return ans.substring(0,ans.length()-1);
    }
}