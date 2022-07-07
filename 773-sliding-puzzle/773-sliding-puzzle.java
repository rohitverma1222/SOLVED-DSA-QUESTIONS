class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<String> mq=new LinkedList<>();
        HashSet<String> hs=new HashSet<>();
        int level=0;
        String org="123450";

        mq.add(config(board));
        hs.add(config(board));

        int [][]dir={{1,3},{0,4,2},{1,5},{0,4},{1,3,5},{2,4}};
        int l=0;
        while(mq.size()>0)
        {
        	int s=mq.size();
        	while(s-->0)
        	{
        		String rem=mq.remove();
                // System.out.println(rem);
        		if(rem.equals(org))
        			return l;
	        	int v=rem.indexOf("0");
        		for(int d:dir[v])
        		{
	        		String get=swap(rem,d,v);
        			if(hs.contains(get)==false)
                    {
        				hs.add(get);
                        mq.add(get);
                    }
        		}

        	}
        	l++;
        }
        return -1;
    }
    public String swap(String rem,int d,int idx)
    {
    	StringBuilder str=new StringBuilder(rem);
    	char ch=rem.charAt(d);

    	str.setCharAt(idx,ch);
    	str.setCharAt(d,'0');

    	return str.toString();
    }
    public String config(int [][]board)
    {
    	StringBuilder str=new StringBuilder();
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length;j++)
    		{
    			str.append(board[i][j]);
    		}
    	}
    	return str.toString();
    }
}