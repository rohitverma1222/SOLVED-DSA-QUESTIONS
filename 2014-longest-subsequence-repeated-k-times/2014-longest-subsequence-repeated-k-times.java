class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
    	int []arr=new int[26];
    	for(char ch:s.toCharArray())
    	{
    		arr[ch-'a']++;
    	}
    	List<String> li=new ArrayList<>();
    	for(int i=0;i<arr.length;i++)
    	{
    		if(arr[i]>=k)
    			li.add((char)(i+'a')+"");
    	}

        LinkedList<String> mq=new LinkedList<>();
        String ans="";
        mq.add("");
        while (mq.size()>0) {
        	int size=mq.size();
        	while (size-->0) {
        		String rem=mq.remove();
        		for(String sss:li)
        		{
        			if(isSub(s,rem+sss,k))
        				mq.add(rem+sss);
        		}	
        		ans=rem;	
        	}	
        }
        return ans;
    }
    public boolean isSub(String s,String curr,int k)
    {
    	int j=0;
    	int rep=0;
    	for(int i=0;i<s.length();i++)
    	{
    		if(s.charAt(i)==curr.charAt(j))
    		{
    			j++;
    		}
    		if(j==curr.length())
    		{
    			rep++;
    			j=0;
    		}

    		if(rep>=k)
    			return true;
    	}
    	return false;
    }
}