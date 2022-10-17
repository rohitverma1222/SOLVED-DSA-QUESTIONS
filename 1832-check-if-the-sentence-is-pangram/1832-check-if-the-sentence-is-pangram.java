class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26)
            return false;
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<sentence.length();i++)
        {
            if(!hs.contains(sentence.charAt(i)))
                hs.add(sentence.charAt(i));
        }
        if(hs.size()<26)
            return false;
        else
            return true;
    }
}