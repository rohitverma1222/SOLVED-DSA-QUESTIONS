class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str=new StringBuilder();
        for(String s:word1)
            str.append(s);

        StringBuilder str1=new StringBuilder();
        for(String s:word2)
            str1.append(s);

        return str.toString().equals(str1.toString());
    }
}