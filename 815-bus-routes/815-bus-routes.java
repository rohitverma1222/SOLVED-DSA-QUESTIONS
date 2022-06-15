class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
int n = routes.length;
    HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < routes[i].length; j++)
      {
        int val = routes[i][j];
        ArrayList<Integer> ar = hs.getOrDefault(val, new ArrayList<>());
        ar.add(i);
          min=Math.min(min,val);
          max=Math.max(max,val);
          
        hs.put(val, ar);
      }
    }
        int range=max-min+1;

    Queue<Integer> mq = new LinkedList<>();
    boolean []busStopno = new boolean[range+1];
    boolean[] busvis = new boolean[n];
    int level = 0;
    mq.add(S);
    busStopno[S-min]=true;
    while (mq.size() > 0)
    {
      int size = mq.size();
      while (size-- > 0)
      {
        int rem = mq.remove();

        if (rem == T)
          return level;

        ArrayList<Integer> ar = hs.get(rem);
        for (int val : ar)
        {
          if (busvis[val]==true)
            continue;

          int []arr = routes[val];
          for (int busStops : arr)
          {
            if (busStopno[busStops-min])
              continue;

            busStopno[busStops-min]=true;
            mq.add(busStops);
          }
          busvis[val]=true;
        }
      }
      level++;
    }

    return -1;
  }
}