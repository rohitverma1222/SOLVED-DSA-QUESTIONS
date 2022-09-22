class Solution {
    public String reverseWords(String s) {
     StringBuilder str=new StringBuilder();
        String []ss=s.split(" ");
        for(int i=0;i<ss.length;i++)
        {
            str.append(reverse(ss[i])+" ");
        }
        String ans=str.toString();
        return ans.substring(0,ans.length()-1);
    }
    public String reverse(String rev)
    {
        return new StringBuilder(rev).reverse().toString();
    }
}