class Solution {
    public int uniqueMorseRepresentations(String[] words) {
       String []arr= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> hs=new HashSet<>();
        
        for(String str:words)
        {
            String s="";
            for(char ch:str.toCharArray())
            {
                s+=arr[ch-'a'];
            }
            
            hs.add(s);
        }
        return hs.size();
    }
}