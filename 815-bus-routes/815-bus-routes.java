class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
int n = routes.length;
    HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < routes[i].length; j++)
      {
        int val = routes[i][j];
        ArrayList<Integer> ar = hs.getOrDefault(val, new ArrayList<>());
        ar.add(i);
        hs.put(val, ar);
      }
    }

    Queue<Integer> mq = new LinkedList<>();
    HashSet<Integer> busStopno = new HashSet<>();
    HashSet<Integer> busvis = new HashSet<>();
    int level = 0;
    mq.add(S);
    busStopno.add(S);
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
          if (busvis.contains(val))
            continue;
          int []arr = routes[val];
          for (int busStops : arr)
          {
            if (busStopno.contains(busStops))
              continue;

            busStopno.add(busStops);
            mq.add(busStops);
          }
          busvis.add(val);
        }
      }
      level++;
    }

    return -1;
  }
}