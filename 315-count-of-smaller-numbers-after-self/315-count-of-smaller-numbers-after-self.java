class Solution {
    class pair{
        int idx;
        int val;
        pair(int idx,int val)
        {
            this.idx=idx;
            this.val=val;
        }
    }
    int []ret;
    public List<Integer> countSmaller(int[] arr) {
        ret=new int[arr.length];
        pair []p=new pair[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            p[i]=new pair(i,arr[i]);
        }


        List<Integer> li=new ArrayList<>();
        mergeSort(p,0,arr.length-1);
        for(int i:ret)
        {
            li.add(i);
        }
        return li;
    }
    public pair[] mergeSort(pair []arr,int l,int h)
    {
        if(l>=h)
        {
            pair p=new pair(arr[l].idx,arr[l].val);
            return new pair[]{p};
        }
        int mid=(l+h)/2;
        pair a[]=mergeSort(arr,l,mid);
        pair b[]=mergeSort(arr,mid+1,h);

        return mergeList(a,b);
    }
    public pair[] mergeList(pair[] a,pair []b)
    {
        int i=0;
        int j=0;
        int k=0;
        pair ans[]=new pair[a.length+b.length];
        while(i<a.length && j<b.length)
        {
            if(a[i].val>b[j].val)
            {
                ans[k++]=a[i];
                ret[a[i].idx]+=(b.length-j);
                i++;
            }
            else{
                ans[k++]=b[j];
                j++;
            }
        }

        while(i<a.length)
        {
            
                ans[k++]=a[i];
                i++;
        }

        while(j<b.length)
        {
                ans[k++]=b[j];
                j++;
            
        }
        return ans;
    }
}