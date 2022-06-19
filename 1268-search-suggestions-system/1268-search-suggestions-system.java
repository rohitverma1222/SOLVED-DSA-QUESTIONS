class Solution {
    public List<List<String>> suggestedProducts(String[] products, String s) {
        List<List<String>> li=new LinkedList<>();
        Arrays.sort(products);
        String se="";
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            se+=ch+"";
            List<String> l=sort(se,products);
            li.add(l);
        }
        return li;
    }
    public List<String> sort(String str,String []products)
    {
        List<String> li=new LinkedList<>();
        int k=str.length();
        for(int i=0;i<products.length;i++)
        {
            if(products[i].length()<k)
            {
                continue;
            }
            String check=products[i].substring(0,k);
            if(li.size()<3 && str.equals(check))
            {
                li.add(products[i]);
            }
        }
        return li;
    }
}