class Solution {
        public int kSimilarity(String s1, String s2) {
        Queue<String> mq=new LinkedList<>();
        HashSet<String> hs=new HashSet<>();
        // int l=0;

        mq.add(s1);
        hs.add(s1);

        int l=0;
        while(mq.size()>0)
        {
        	int s=mq.size();
        	while(s-->0)
        	{
        		String rem=mq.remove();
        		if(rem.equals(s2))
        			return l;
	        	
	        	for(String ss:generate(rem,s2))
	        	{
                    // System.out.println(ss);
	        		if(hs.contains(ss)==false)
	        		{
	        			hs.add(ss);
	        			mq.add(ss);
	        		}
	        	}
        	}
        	l++;
        }
        return -1;
    }
    public String swap(String rem,int i,int j)
    {
    	StringBuilder str=new StringBuilder(rem);
    	char ch1=str.charAt(i);
    	char ch2=str.charAt(j);
    	str.setCharAt(i,ch2);
    	str.setCharAt(j,ch1);

    	return str.toString();
    }
    public ArrayList<String> generate(String s1,String s2)
    {
    	ArrayList<String> ar=new ArrayList<>();
    	int idx=0;
    	for(int i=0;i<s1.length();i++)
    	{
    		if(s1.charAt(i)!=s2.charAt(i))
    		{
    			idx=i;break;
    		}
    	}


    	for(int i=idx+1;i<s1.length();i++)
    	{
    		if(s1.charAt(i)==s2.charAt(idx))
    		{
    			ar.add(swap(s1,i,idx));
    		}
    	}
    	return ar;
    }
}