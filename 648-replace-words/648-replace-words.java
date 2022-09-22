class Solution {
    class Node{
        boolean eow=false;
        Node []children=new Node[26];
    }
    Node root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root=new Node();
        insert(dictionary);
        String []ans=sentence.split(" ");
        String main="";
        for(int i=0;i<ans.length;i++)
        {
            String word=ans[i];
            Node node=root;
            for(int j=0;j<word.length();j++)
            {
                char ch=word.charAt(j);
                if(node.children[ch-'a']!=null)
                {
                    node=node.children[ch-'a'];
                    if(node.eow)
                    {
                        ans[i]=word.substring(0,j+1);
                        break;
                    }
                }
                else
                    break;
            }
        }
        return String.join(" ",ans);
    }
    
    public void insert(List<String> dictionary)
    {
        for(String str:dictionary)
        {
            Node node=root;
            for(char ch:str.toCharArray())
            {
                if(node.children[ch-'a']==null)
                    node.children[ch-'a']=new Node();
                node=node.children[ch-'a'];
            }
            node.eow=true;
        }
    }
}