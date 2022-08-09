class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int ct=0;
        int i=0;
        int j=0;
        int res=0;
        for(char ch:answerKey.toCharArray())
        {
            if(ch=='T')
            {
                ct++;
            }
            while(ct>k)
            {
            if(answerKey.charAt(j)=='T')
                    ct--;
                j++;
            }
            res=Math.max(res,i-j+1);
            i++;
        }

        i=0;
        j=0;

        int an=0;
        ct=0;
        for(char ch:answerKey.toCharArray())
        {
            if(ch=='F')
            {
                ct++;
            }
            while(ct>k)
            {
                if(answerKey.charAt(j)=='F')
                    ct--;
                j++;
            }
            an=Math.max(an,i-j+1);
            i++;
        }
        return Math.max(an,res);
    }
}