class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent=new HashMap<>();
        mult=new HashMap<>();
        
        for(List<String> eq:equations)
        {
            Add(eq.get(0));
            Add(eq.get(1));
        }
        
        int i=0;
//         union
        for(List<String> eq:equations)
        {
            String l1=find(eq.get(0));
            String l2=find(eq.get(1));
            
            Double m0=mult.get(eq.get(0));
            Double m1=mult.get(eq.get(1));
            
            mult.put(l1,(m1*values[i])/m0);
            
            parent.put(l1,l2);
            
            i++;
        }
        
        double res[]=new double[queries.size()];
        
        i=0;
        for(List<String> eq:queries)
        {
            String q1=eq.get(0);
            String q2=eq.get(1);

            if(parent.containsKey(q1)==false || !parent.containsKey(q2))
            {
                res[i]=-1;
                i++;
                continue;
            }

            String l0=find(q1);
            String l1=find(q2);

            if(l0.equals(l1)==false)
            {
                res[i]=-1;
                i++;
                continue;
            }

            Double m0=mult.get(q1);
            Double m1=mult.get(q2);

            res[i]=m0/m1;
            i++;
        }
        return res;
        
    }
    HashMap<String,String> parent;
    HashMap<String,Double> mult; 
    public void Add(String x)
    {
        if(!parent.containsKey(x))
        {
            parent.put(x,x);
            mult.put(x,1.0);
        }
    }
    
    public String find(String x)
    {
        if(parent.get(x).equals(x))
        {
            return parent.get(x);
        }
        else
        {
            String cp=parent.get(x);
            String fp=find(parent.get(x));
            
            mult.put(x,mult.get(cp)*mult.get(x));
            parent.put(x,fp);
            return fp;
        }
    }
}