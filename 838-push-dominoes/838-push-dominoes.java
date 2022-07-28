class Solution {
    public String pushDominoes(String dominoes) {
        dominoes="L"+dominoes+"R";
        int pre=0;
        char []arr=dominoes.toCharArray();
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]=='R')
            {
                if(arr[pre]=='R')
                {
                    for(int j=pre+1;j<i;j++)
                    {
                        arr[j]='R';
                    }
                }
                pre=i;
            }
            else if(arr[i]=='L')
            {
                if(arr[pre]=='L')
                {
                    for(int j=pre+1;j<i;j++)
                    {
                        arr[j]='L';
                    }
                }
                else if(arr[pre]=='R')
                {
                    int left=pre+1;
                    int right=i-1;
                    while(left<right)
                    {
                        arr[left]='R';
                        arr[right]='L';

                        left++;
                        right--;
                    }
                }
                pre=i;
            }
        }

        StringBuilder str=new StringBuilder();

        for(int i=1;i<arr.length-1;i++)
        {
            str.append(arr[i]);
        }
        return str.toString();
    }
}