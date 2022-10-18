class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> hs=new HashMap<>();
        for(int i=0;i<paths.size();i++)
        {
            String str=paths.get(i).get(0);
            String str1=paths.get(i).get(1);
            
            if(hs.containsKey(str))
            {
                int g=hs.get(str)+1;
                hs.put(str,g);
            }
            else
                hs.put(str,1);
            
            
            if(hs.containsKey(str1))
            {
                int g=hs.get(str1)+1;
                hs.put(str1,g);
            }
            else
                hs.put(str1,1);
            
        }
        String ans="";
        for(int i=0;i<paths.size();i++)
        {
            String str=paths.get(i).get(0);
            String str1=paths.get(i).get(1);
            if(hs.get(str1)==1)
            {
                return str1;
            }

        }
        return "";
    }
}